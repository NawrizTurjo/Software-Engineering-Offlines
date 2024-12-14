package Onlines.Practice;

interface MediaPly {
    void play(String audio, String file);
}

interface AvdMedia {
    void playMP3(String file);

    void playMP4(String file);
}

class MP3Playerr implements AvdMedia {

    @Override
    public void playMP3(String file) {
        System.out.println("VLC");
    }

    @Override
    public void playMP4(String file) {
        // do nothing
    }

}

class MP4Playerr implements AvdMedia {

    @Override
    public void playMP3(String file) {
        // do nothing
    }

    @Override
    public void playMP4(String file) {
        System.out.println("Video");
    }

}

class MediaAdapterr implements MediaPly {

    AvdMedia media;

    public MediaAdapterr(String audioType) {
        if (audioType.equalsIgnoreCase("MP3")) {
            media = new MP3Playerr();
        } else if (audioType.equalsIgnoreCase("MP4")) {
            media = new MP4Playerr();
        }
    }

    @Override
    public void play(String audio, String file) {
        if (audio.equalsIgnoreCase("MP3")) {
            media.playMP3(file);
        } else if (audio.equalsIgnoreCase("MP4")) {
            media.playMP4(file);
        }
    }

}

class MediaPlyer implements MediaPly {

    MediaAdapterr mediaAdapter;

    @Override
    public void play(String audio, String file) {
        if (audio.equalsIgnoreCase("MP3") || audio.equalsIgnoreCase("MP4")) {
            mediaAdapter = new MediaAdapterr(audio);
            mediaAdapter.play(audio, file);
        } else {
            System.out.println("Invalid media. " + audio + " format not supported");
        }
    }

}

public class MediaAdv {

    public static void main(String[] args) {
        MediaPlyer audioPlayer = new MediaPlyer();

        audioPlayer.play("MP3", "beyond the horizon.mp3");
        audioPlayer.play("MP4", "alone.mp4");
        audioPlayer.play("VLC", "far far away.vlc");
    }
}
