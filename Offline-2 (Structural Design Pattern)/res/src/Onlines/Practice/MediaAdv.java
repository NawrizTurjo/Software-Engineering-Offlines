package Onlines.Practice;

interface MediaPly {
    void play(String audio, String file);
}

interface AvdMedia {
    void playMP3(String file);

    void playMP4(String file);
}

class MP3Player implements AvdMedia {

    @Override
    public void playMP3(String file) {
        System.out.println("VLC");
    }

    @Override
    public void playMP4(String file) {
    }

}

class MP4Player implements AvdMedia {

    @Override
    public void playMP3(String file) {
    }

    @Override
    public void playMP4(String file) {
        System.out.println("Video");
    }

}




public class MediaAdv {

}
