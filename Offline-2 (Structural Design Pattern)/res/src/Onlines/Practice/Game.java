package Onlines.Practice;

// InputDevice Interface
interface InputDevice {
    String getInput();
}

// GameController Class with specific getControllerInput method
class GameController {
    public String getControllerInput() {
        return "Controller input";
    }
}

// TouchScreen Class with specific getTouchInput method
class TouchScreen {
    public String getTouchInput() {
        return "Touch screen input";
    }
}

// GameControllerAdapter class
class GameControllerAdapter implements InputDevice {
    private GameController gameController;

    public GameControllerAdapter(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String getInput() {
        // Delegate to the GameController's getControllerInput method
        return gameController.getControllerInput();
    }
}

// TouchScreenAdapter class
class TouchScreenAdapter implements InputDevice {
    private TouchScreen touchScreen;

    public TouchScreenAdapter(TouchScreen touchScreen) {
        this.touchScreen = touchScreen;
    }

    @Override
    public String getInput() {
        // Delegate to the TouchScreen's getTouchInput method
        return touchScreen.getTouchInput();
    }
}

public class Game {
    public static void main(String[] args) {
        // Create instances of GameController and TouchScreen
        GameController gameController = new GameController();
        TouchScreen touchScreen = new TouchScreen();

        // Create adapters for each device
        InputDevice controllerAdapter = new GameControllerAdapter(gameController);
        InputDevice touchScreenAdapter = new TouchScreenAdapter(touchScreen);

        // Use the adapters through the InputDevice interface
        System.out.println("GameController Adapter Input: " + controllerAdapter.getInput());
        System.out.println("TouchScreen Adapter Input: " + touchScreenAdapter.getInput());
    }
}
