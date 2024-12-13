package OtherOnlines;

import java.util.ArrayList;
import java.util.List;

interface SmartHub {
    void update(String message, SmartDevice smartDevice);

    void registerDevice(SmartDevice smartDevice);

    void removeDevice(SmartDevice smartDevice);
}

class SmartHubImpl implements SmartHub {
    // private String name;
    private List<SmartDevice> devices = new ArrayList<>();

    @Override
    public void update(String message, SmartDevice smartDevice) {
        System.out.println(smartDevice.getName() + " reports: " + message);
        for (SmartDevice device : devices) {
            if (device != smartDevice)
                device.recieveUpdate(message, smartDevice);
        }
    }

    @Override
    public void registerDevice(SmartDevice smartDevice) {
        devices.add(smartDevice);
    }

    @Override
    public void removeDevice(SmartDevice smartDevice) {
        devices.remove(smartDevice);
    }

}

abstract class SmartDevice {
    protected SmartHub smartHub;
    protected String name;

    public SmartDevice(String name, SmartHub hub) {
        this.name = name;
        this.smartHub = hub;
    }

    public void sendUpdate(String s) {
        // System.out.println(name + " reports: " + s);
        smartHub.update(s, this);
    }

    public abstract void recieveUpdate(String s, SmartDevice sender);

    public String getName() {
        return this.name;
    }

}

class SmartLight extends SmartDevice {
    public SmartLight(String name, SmartHub hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDevice sender) {
        if (s.equalsIgnoreCase("away")) {
            System.out.println(name + " turned off.");
        } else if (s.equalsIgnoreCase("unlocked")) {
            System.out.println(name + " is notified of unlocked status.");
        }

    }

}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String name, SmartHub hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDevice sender) {
        if (s.equalsIgnoreCase("locked")) {
            System.out.println(name + " set to eco mode.");
        } else if (s.equalsIgnoreCase("unlocked")) {
            System.out.println(name + " is notified of unlocked status.");
        }
    }
}

class SmartDoorLock extends SmartDevice {
    public SmartDoorLock(String name, SmartHub hub) {
        super(name, hub);
    }

    public void sendUpdate(String s) {
        super.sendUpdate(s);
    }

    @Override
    public void recieveUpdate(String s, SmartDevice sender) {
        if (s.equalsIgnoreCase("malfunctioned")) {
            System.out.println(name + " got a malfunction report.");
        }
    }
}

public class MediatorComplex {
    public static void main(String[] args) {
        SmartHub hub = new SmartHubImpl();

        // Create devices
        SmartDevice light = new SmartLight("Living Room Light", hub);
        SmartDevice thermostat = new SmartThermostat("Home Thermostat", hub);
        SmartDevice doorLock = new SmartDoorLock("Main Door Lock", hub);

        // Devices register themselves with the hub
        hub.registerDevice(light);
        hub.registerDevice(thermostat);
        hub.registerDevice(doorLock);

        // Simulate device interactions
        doorLock.sendUpdate("locked"); // Lock the door
        thermostat.sendUpdate("away"); // Thermostat enters away mode
        doorLock.sendUpdate("unlocked"); // Unlock the door
        light.sendUpdate("on"); // Turn the light on
    }

}
