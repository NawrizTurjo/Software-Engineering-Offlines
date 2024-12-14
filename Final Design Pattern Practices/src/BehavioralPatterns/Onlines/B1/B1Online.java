package BehavioralPatterns.Onlines.B1;

interface TrafficLightState {
    void changeState(TrafficLight light);
}

class RedState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Red Light");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        light.setState(new YellowState(true));
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Green Light");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        light.setState(new YellowState(false));
    }
}

class YellowState implements TrafficLightState {
    private boolean isFromRed;

    public YellowState(boolean boolValue) {
        isFromRed = boolValue;
    }

    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Yellow Light");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // light.setState(new GreenState());
        if (isFromRed) {
            light.setState(new GreenState());
        } else {
            light.setState(new RedState());
        }
    }
}

class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedState();
    }

    public void startTrafficSystem() {
        while (true) {
            state.changeState(this);
        }
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }
}

public class B1Online {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.startTrafficSystem();
    }
}
