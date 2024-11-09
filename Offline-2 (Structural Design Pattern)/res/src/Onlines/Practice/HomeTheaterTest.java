package Onlines.Practice;

class DVDPlayer {
    public void on() { System.out.println("DVD Player on"); }
    public void off() { System.out.println("DVD Player off"); }
    public void play(String movie) { System.out.println("Playing " + movie); }
    public void stop() { System.out.println("Stopping DVD"); }
}

class Projector {
    public void on() { System.out.println("Projector on"); }
    public void off() { System.out.println("Projector off"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
}

class SoundSystem {
    public void on() { System.out.println("Sound System on"); }
    public void off() { System.out.println("Sound System off"); }
    public void setVolume(int level) { System.out.println("Setting volume to " + level); }
}

class Lights {
    public void dim(int level) { System.out.println("Dimming lights to " + level + "%"); }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem soundSystem, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch a movie...");
        dvdPlayer.on();
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(10);
        lights.dim(20);
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.stop();
        dvdPlayer.off();
        projector.off();
        soundSystem.off();
        lights.dim(100);
    }
}

// Testing
public class HomeTheaterTest {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights);
        
        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}

