package BehavioralPatterns.OtherCodes;

import java.util.ArrayList;
import java.util.List;

interface SmartHubMediator {
    void update(String message, SmartDeviceMediator smartDevice);

    void registerDevice(SmartDeviceMediator smartDevice);

    void removeDevice(SmartDeviceMediator smartDevice);
}

class SmartHubImplMediator implements SmartHubMediator {
    // private String name;
    private List<SmartDeviceMediator> devices = new ArrayList<>();

    @Override
    public void update(String message, SmartDeviceMediator smartDevice) {
        System.out.println(smartDevice.getName() + " reports: " + message);
        for (SmartDeviceMediator device : devices) {
            if (device != smartDevice)
                device.recieveUpdate(message, smartDevice);
        }
    }

    @Override
    public void registerDevice(SmartDeviceMediator smartDevice) {
        devices.add(smartDevice);
    }

    @Override
    public void removeDevice(SmartDeviceMediator smartDevice) {
        devices.remove(smartDevice);
    }

}

abstract class SmartDeviceMediator {
    protected SmartHubMediator smartHub;
    protected String name;

    public SmartDeviceMediator(String name, SmartHubMediator hub) {
        this.name = name;
        this.smartHub = hub;
        hub.registerDevice(this);
    }

    public void sendUpdate(String s) {
        // System.out.println(name + " reports: " + s);
        smartHub.update(s, this);
    }

    public abstract void recieveUpdate(String s, SmartDeviceMediator sender);

    public String getName() {
        return this.name;
    }

}

class SmartLightMediator extends SmartDeviceMediator {
    public SmartLightMediator(String name, SmartHubMediator hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDeviceMediator sender) {
        if (s.equalsIgnoreCase("away")) {
            System.out.println(name + " turned off.");
        } else if (s.equalsIgnoreCase("unlocked")) {
            System.out.println(name + " is notified of unlocked status.");
        }

    }

}

class SmartThermostatMediator extends SmartDeviceMediator {
    public SmartThermostatMediator(String name, SmartHubMediator hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDeviceMediator sender) {
        if (s.equalsIgnoreCase("locked")) {
            System.out.println(name + " set to eco mode.");
        } else if (s.equalsIgnoreCase("unlocked")) {
            System.out.println(name + " is notified of unlocked status.");
        }
    }
}

class SmartDoorLockMediator extends SmartDeviceMediator {
    public SmartDoorLockMediator(String name, SmartHubMediator hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDeviceMediator sender) {
        if (s.equalsIgnoreCase("malfunctioned")) {
            System.out.println(name + " got a malfunction report.");
        }
    }
}

public class MediatorComplex {
    public static void main(String[] args) {
        SmartHubMediator hub = new SmartHubImplMediator();

        // Create devices
        SmartDeviceMediator light = new SmartLightMediator("Living Room Light", hub);
        SmartDeviceMediator thermostat = new SmartThermostatMediator("Home Thermostat", hub);
        SmartDeviceMediator doorLock = new SmartDoorLockMediator("Main Door Lock", hub);

        // Devices register themselves with the hub
        // hub.registerDevice(light);
        // hub.registerDevice(thermostat);
        // hub.registerDevice(doorLock);

        // Simulate device interactions
        doorLock.sendUpdate("locked"); // Lock the door
        thermostat.sendUpdate("away"); // Thermostat enters away mode
        doorLock.sendUpdate("unlocked"); // Unlock the door
        light.sendUpdate("on"); // Turn the light on
    }

}
