package Onlines.Practice;

interface VideoService {
    void playVideo(String videoTitle, String quality);
}

class VideoPlayer {
    public void playSD(String videoTitle) {
        System.out.println("Playing SD video: " + videoTitle);
    }

    public void playHD(String videoTitle) {
        System.out.println("Playing HD video: " + videoTitle);
    }
}

class VideoPlayerProxy implements VideoService { // Adapter Class
    private VideoPlayer videoPlayer;
    private boolean isPremiumUser;

    public VideoPlayerProxy(boolean isPremiumUser) {
        this.videoPlayer = new VideoPlayer();
        this.isPremiumUser = isPremiumUser;
    }

    @Override
    public void playVideo(String videoTitle, String quality) {
        if (quality.equalsIgnoreCase("HD")) {
            if (isPremiumUser) {
                videoPlayer.playHD(videoTitle);
            } else {
                System.out.println("Access Denied: HD video is available for premium users only.");
            }
        } else if (quality.equalsIgnoreCase("SD")) {
            videoPlayer.playSD(videoTitle);
        } else {
            System.out.println("Unsupported quality: " + quality);
        }
    }
}

public class VideoStreamingApp {
    public static void main(String[] args) {
        // Basic user
        VideoService basicUser = new VideoPlayerProxy(false);
        basicUser.playVideo("Nature Documentary", "SD"); // Allowed
        basicUser.playVideo("Nature Documentary", "HD"); // Access Denied

        System.out.println();

        // Premium user
        VideoService premiumUser = new VideoPlayerProxy(true);
        premiumUser.playVideo("Nature Documentary", "SD"); // Allowed
        premiumUser.playVideo("Nature Documentary", "HD"); // Allowed
    }
}
