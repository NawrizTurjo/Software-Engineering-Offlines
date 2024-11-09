package Onlines.Practice;

// Legacy MP3 Player, which we cannot modify
class MP3Player {
    public void playMP3(String fileName) {
        System.out.println("Playing MP3: " + fileName);
    }
}

// Client Interface expected by the application
interface MediaPlayer {
    void play(String fileName);
}

// Application class that depends on the MediaPlayer interface
class AudioPlayer {
    private MediaPlayer mediaPlayer;

    public AudioPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void playAudio(String fileName) {
        mediaPlayer.play(fileName);
    }
}

class MP3Adapter implements MediaPlayer {

    private MP3Player mp3Player;

    public MP3Adapter(MP3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    @Override
    public void play(String fileName) {
        mp3Player.playMP3(fileName);
    }

}

// Main Class
public class Media {
    public static void main(String[] args) {
        // Legacy service instance
        MP3Player mp3Player = new MP3Player();

        // Adapter to make MP3Player compatible with MediaPlayer interface
        MediaPlayer mediaPlayer = new MP3Adapter(mp3Player);

        AudioPlayer player = new AudioPlayer(mediaPlayer);
        player.playAudio("song.mp3"); // Output: Playing MP3: song.mp3
    }
}
