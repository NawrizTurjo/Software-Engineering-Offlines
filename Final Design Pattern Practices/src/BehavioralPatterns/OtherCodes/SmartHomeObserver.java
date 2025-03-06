package BehavioralPatterns.OtherCodes;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface DeviceObserver {
    void update(String eventType, Object data);
}

// Subject Interface
interface SmartHomeControllerObserver {
    void registerDevice(DeviceObserver device);
    void removeDevice(DeviceObserver device);
    void notifyDevices(String eventType, Object data);
}

// Concrete Smart Home Controller
class HomeControllerObserver implements SmartHomeControllerObserver {
    private List<DeviceObserver> devices = new ArrayList<>();

    @Override
    public void registerDevice(DeviceObserver device) {
        devices.add(device);
    }

    @Override
    public void removeDevice(DeviceObserver device) {
        devices.remove(device);
    }

    @Override
    public void notifyDevices(String eventType, Object data) {
        for (DeviceObserver device : devices) {
            device.update(eventType, data);
        }
    }
}

// Concrete Devices
class SmartLightObserver implements DeviceObserver {
    @Override
    public void update(String eventType, Object data) {
        if ("motion".equals(eventType) && (boolean) data) {
            System.out.println("SmartLight: Motion detected, turning on the light.");
        } else if ("lightLevel".equals(eventType) && (int) data < 20) {
            System.out.println("SmartLight: Light level low, turning on the light.");
        }
    }
}

class SmartThermostatObserver implements DeviceObserver {
    @Override
    public void update(String eventType, Object data) {
        if ("temperature".equals(eventType) && (int) data < 18) {
            System.out.println("SmartThermostat: Temperature is low, increasing heat.");
        }
    }
}

class SecurityCameraObserver implements DeviceObserver {
    @Override
    public void update(String eventType, Object data) {
        if ("motion".equals(eventType) && (boolean) data) {
            System.out.println("SecurityCamera: Motion detected, starting recording.");
        }
    }
}

class AlarmSystemObserver implements DeviceObserver {
    private boolean userAtHome = true; // Assume user is at home by default

    public void setUserAtHome(boolean atHome) {
        this.userAtHome = atHome;
    }

    @Override
    public void update(String eventType, Object data) {
        if ("motion".equals(eventType) && (boolean) data && !userAtHome) {
            System.out.println("AlarmSystem: Unauthorized motion detected, triggering alarm!");
        }
    }
}

// Grouped Devices (Composite Pattern for Groups)
class DeviceGroupObserver implements DeviceObserver {
    private List<DeviceObserver> devices = new ArrayList<>();

    public void addDevice(DeviceObserver device) {
        devices.add(device);
    }

    public void removeDevice(DeviceObserver device) {
        devices.remove(device);
    }

    @Override
    public void update(String eventType, Object data) {
        for (DeviceObserver device : devices) {
            device.update(eventType, data);
        }
    }
}

// Main Class
public class SmartHomeObserver {
    public static void main(String[] args) {
        HomeControllerObserver controller = new HomeControllerObserver();

        SmartLightObserver light = new SmartLightObserver();
        SmartThermostatObserver thermostat = new SmartThermostatObserver();
        SecurityCameraObserver camera = new SecurityCameraObserver();
        AlarmSystemObserver alarm = new AlarmSystemObserver();

        controller.registerDevice(light);
        controller.registerDevice(thermostat);
        controller.registerDevice(camera);
        controller.registerDevice(alarm);

        // Simulate Events
        System.out.println("Event: Motion detected");
        controller.notifyDevices("motion", true);

        System.out.println("\nEvent: Temperature dropped to 15°C");
        controller.notifyDevices("temperature", 15);

        System.out.println("\nUser is leaving home...");
        alarm.setUserAtHome(false);

        System.out.println("Event: Motion detected again");
        controller.notifyDevices("motion", true);

        // Grouped Devices
        DeviceGroupObserver livingRoomGroup = new DeviceGroupObserver();
        livingRoomGroup.addDevice(light);
        livingRoomGroup.addDevice(camera);

        System.out.println("\nActivating Living Room Group...");
        livingRoomGroup.update("motion", true);
    }
}

