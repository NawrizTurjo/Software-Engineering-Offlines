package OtherOnlines;

interface TrafficLightState {
    void changeState(TrafficLight light);
}

class RedState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Red Light");
        try {
            Thread.sleep(5000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        light.setState(new YellowState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Green Light");
        try {
            Thread.sleep(10000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        light.setState(new RedState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight light) {
        System.out.println("Yellow Light");
        try {
            Thread.sleep(2000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        light.setState(new GreenState());
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
