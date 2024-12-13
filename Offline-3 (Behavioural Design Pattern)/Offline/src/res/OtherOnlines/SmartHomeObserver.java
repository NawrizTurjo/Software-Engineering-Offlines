package OtherOnlines;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Device {
    void update(String eventType, Object data);
}

// Subject Interface
interface SmartHomeController {
    void registerDevice(Device device);
    void removeDevice(Device device);
    void notifyDevices(String eventType, Object data);
}

// Concrete Smart Home Controller
class HomeController implements SmartHomeController {
    private List<Device> devices = new ArrayList<>();

    @Override
    public void registerDevice(Device device) {
        devices.add(device);
    }

    @Override
    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public void notifyDevices(String eventType, Object data) {
        for (Device device : devices) {
            device.update(eventType, data);
        }
    }
}

// Concrete Devices
class SmartLight implements Device {
    @Override
    public void update(String eventType, Object data) {
        if ("motion".equals(eventType) && (boolean) data) {
            System.out.println("SmartLight: Motion detected, turning on the light.");
        } else if ("lightLevel".equals(eventType) && (int) data < 20) {
            System.out.println("SmartLight: Light level low, turning on the light.");
        }
    }
}

class SmartThermostat implements Device {
    @Override
    public void update(String eventType, Object data) {
        if ("temperature".equals(eventType) && (int) data < 18) {
            System.out.println("SmartThermostat: Temperature is low, increasing heat.");
        }
    }
}

class SecurityCamera implements Device {
    @Override
    public void update(String eventType, Object data) {
        if ("motion".equals(eventType) && (boolean) data) {
            System.out.println("SecurityCamera: Motion detected, starting recording.");
        }
    }
}

class AlarmSystem implements Device {
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
class DeviceGroup implements Device {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public void update(String eventType, Object data) {
        for (Device device : devices) {
            device.update(eventType, data);
        }
    }
}

// Main Class
public class SmartHomeObserver {
    public static void main(String[] args) {
        HomeController controller = new HomeController();

        SmartLight light = new SmartLight();
        SmartThermostat thermostat = new SmartThermostat();
        SecurityCamera camera = new SecurityCamera();
        AlarmSystem alarm = new AlarmSystem();

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
        DeviceGroup livingRoomGroup = new DeviceGroup();
        livingRoomGroup.addDevice(light);
        livingRoomGroup.addDevice(camera);

        System.out.println("\nActivating Living Room Group...");
        livingRoomGroup.update("motion", true);
    }
}

