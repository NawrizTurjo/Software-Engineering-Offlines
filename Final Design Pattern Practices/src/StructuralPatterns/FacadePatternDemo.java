package StructuralPatterns;

class RobotBody {
    public void createRobot() {
        System.out.println("Refer the manual before creating a robot");
    }

    public void createHands() {
        System.out.println("Hands manufactured");
    }

    public void createRemainingParts() {
        System.out.println("Remaining parts manufactured");
    }

    public void destroyRobot() {
        System.out.println("Refer the manual before destroying a robot");
    }

    public void destroyRemainingParts() {
        System.out.println("Remaining parts destroyed");
    }
}

class RobotColor{
    public void setDefaultColor() {
        System.out.println("Default color set");
    }

    public void setGreenColor() {
        System.out.println("Green color set");
    }
}

class RobotHands{
    public void setMilanoHands() {
        System.out.println("Milano hands set");
    }

    public void setRobonautHands() {
        System.out.println("Robonaut hands set");
    }

    public void resetMilanoHands() {
        System.out.println("Milano hands reset");
    }

    public void resetRobonautHands() {
        System.out.println("Robonaut hands reset");
    }
}

class RobotFacade {
    private RobotBody body;
    private RobotColor color;
    private RobotHands hands;

    public RobotFacade() {
        body = new RobotBody();
        color = new RobotColor();
        hands = new RobotHands();
    }

    public void createGreenMilanoRobot() {
        System.out.println("Creating a green milano robot");
        body.createRobot();
        body.createHands();
        hands.setMilanoHands();
        color.setGreenColor();
        body.createRemainingParts();
        System.out.println("Green milano robot created");
    }

    public void createRedRobonautRobot() {
        System.out.println("Creating a red robonaut robot");
        body.createRobot();
        body.createHands();
        hands.setRobonautHands();
        color.setDefaultColor();
        body.createRemainingParts();
        System.out.println("Red robonaut robot created");
    }

    public void destroyGreenMilanoRobot() {
        System.out.println("Destroying a green milano robot");
        body.destroyRobot();
        hands.resetMilanoHands();
        body.destroyRemainingParts();
        System.out.println("Green milano robot destroyed");
    }

    public void destroyRedRobonautRobot() {
        System.out.println("Destroying a red robonaut robot");
        body.destroyRobot();
        hands.resetRobonautHands();
        body.destroyRemainingParts();
        System.out.println("Red robonaut robot destroyed");
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        RobotFacade facade = new RobotFacade();
        facade.createGreenMilanoRobot();
        facade.createRedRobonautRobot();
        facade.destroyGreenMilanoRobot();
        facade.destroyRedRobonautRobot();
    }
}
