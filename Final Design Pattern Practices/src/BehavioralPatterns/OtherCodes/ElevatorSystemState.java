package BehavioralPatterns.OtherCodes;

import java.util.LinkedList;
import java.util.Queue;

interface State {
    void handleRequest(Elevator elevator);
    void update(Elevator elevator);
}

class Elevator {
    private State currentState;
    private Queue<Integer> requests;
    private int currentFloor;
    private boolean doorOpen;

    public Elevator() {
        this.currentState = new IdleState();
        this.requests = new LinkedList<>();
        this.currentFloor = 1; // Elevator starts at floor 1
        this.doorOpen = false;
    }

    // Add floor requests
    public void addRequest(int floor) {
        requests.offer(floor);
    }

    // Get the next request from the queue
    public int getNextRequest() {
        return requests.poll();
    }

    // Set the current state
    public void setState(State state) {
        this.currentState = state;
    }

    // Check if there are any pending requests
    public boolean hasRequests() {
        return !requests.isEmpty();
    }

    // Update the elevator (simulate the passage of time)
    public void update() {
        currentState.update(this); // Call the update method of the current state
        currentState.handleRequest(this); // Handle state-specific actions
    }

    // Getters and Setters
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }
}

class IdleState implements State {
    @Override
    public void handleRequest(Elevator elevator) {
        if (elevator.hasRequests()) {
            int nextFloor = elevator.getNextRequest();
            System.out.println("Elevator is moving to floor " + nextFloor);
            elevator.setState(new MovingState(nextFloor)); // Transition to MovingState
        }
    }

    @Override
    public void update(Elevator elevator) {
        // Idle state doesn't do anything on update
    }
}

class MovingState implements State {
    private int targetFloor;

    public MovingState(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public void handleRequest(Elevator elevator) {
        if (elevator.getCurrentFloor() == targetFloor) {
            System.out.println("Elevator has arrived at floor " + targetFloor);
            elevator.setState(new DoorOpeningState()); // Transition to DoorOpeningState
        }
    }

    @Override
    public void update(Elevator elevator) {
        // Simulate the movement by increasing the floor by 1 or decreasing, depending on direction
        if (elevator.getCurrentFloor() < targetFloor) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        } else if (elevator.getCurrentFloor() > targetFloor) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        }
        System.out.println("Elevator is at floor " + elevator.getCurrentFloor());
    }
}

class DoorOpeningState implements State {
    @Override
    public void handleRequest(Elevator elevator) {
        if (!elevator.isDoorOpen()) {
            elevator.setDoorOpen(true);
            System.out.println("Doors are opening.");
            elevator.setState(new DoorClosingState()); // Transition to DoorClosingState after opening
        }
    }

    @Override
    public void update(Elevator elevator) {
        // Simulate time spent on opening doors
        try {
            Thread.sleep(2000); // Wait for 2 seconds to simulate door opening
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DoorClosingState implements State {
    @Override
    public void handleRequest(Elevator elevator) {
        if (elevator.isDoorOpen()) {
            elevator.setDoorOpen(false);
            System.out.println("Doors are closing.");
            if (elevator.hasRequests()) {
                elevator.setState(new MovingState(elevator.getNextRequest())); // If there are requests, move to the next floor
            } else {
                elevator.setState(new IdleState()); // No more requests, go idle
            }
        }
    }

    @Override
    public void update(Elevator elevator) {
        // Simulate time spent on closing doors
        try {
            Thread.sleep(2000); // Wait for 2 seconds to simulate door closing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ElevatorSystemState {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        // Add initial requests
        elevator.addRequest(5);
        elevator.addRequest(3);
        
        // Simulate the operation of the elevator
        while (true) {
            elevator.update(); // The elevator processes its current state
            try {
                Thread.sleep(1000); // Simulate real-time delays (1 second)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

