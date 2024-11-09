package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface MediaItem {
    int getSize();

    void showDetails();
}

class MusicFile implements MediaItem {
    private String name;
    private int size;

    public MusicFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void showDetails() {
        System.out.println("Music Item, " + this.name + " Size: " + getSize() + " bytes.");
    }
}

class VideoFile implements MediaItem {

    private String name;
    private int size;

    public VideoFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void showDetails() {
        System.out.println("Video Item, " + this.name + " Size: " + getSize() + " bytes.");
    }
}

class MediaFolder implements MediaItem {
    List<MediaItem> medias = new ArrayList<>();

    private String name;

    public MediaFolder(String name) {
        this.name = name;
    }

    public void addMedia(MediaItem mediaItem) {
        medias.add(mediaItem);
    }

    public void removeMedia(MediaItem mediaItem) {
        medias.remove(mediaItem);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (MediaItem mediaItem : medias) {
            totalSize += mediaItem.getSize();
        }
        return totalSize;
    }

    @Override
    public void showDetails() {
        System.out.println("Folder Item " + this.name);
        for (MediaItem mediaItem : medias) {
            mediaItem.showDetails();
        }
    }

}

public class MediaIII {
    public static void main(String[] args) {
        MediaItem music = new MusicFile("m1", 4);
        MediaItem video = new VideoFile("v1", 100);

        MediaFolder root = new MediaFolder("root");
        root.addMedia(music);
        root.addMedia(video);
        // root.showDetails();

        MediaFolder branch = new MediaFolder("branch");
        branch.addMedia(new MusicFile("m2", 6));
        branch.addMedia(new VideoFile("v2", 104));
        root.addMedia(branch);
        root.showDetails();
    }
}
