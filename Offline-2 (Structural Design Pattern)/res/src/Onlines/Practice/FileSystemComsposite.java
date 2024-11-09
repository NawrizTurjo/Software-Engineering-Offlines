package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
    int getSize();
}

class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name + ", Size: " + size + " MB");
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}

public class FileSystemComsposite {
    public static void main(String[] args) {
        File file1 = new File("File1.txt", 10);
        File file2 = new File("File2.txt", 20);
        File file3 = new File("File3.jpg", 50);

        Directory dir1 = new Directory("Documents");
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        Directory dir2 = new Directory("Images");
        dir2.addComponent(file3);

        Directory root = new Directory("Root");
        root.addComponent(dir1);
        root.addComponent(dir2);

        root.showDetails();
        System.out.println("Total Size of Root Directory: " + root.getSize() + " MB");
    }
}

