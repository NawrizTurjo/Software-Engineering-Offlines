package Client;

import java.util.Scanner;

import Factory.FileFactory;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input a path:");
        String path = sc.nextLine();
        FileFactory fileFactory = new FileFactory();
        fileFactory.getFile(path).loadDocument(path);
    }
}
