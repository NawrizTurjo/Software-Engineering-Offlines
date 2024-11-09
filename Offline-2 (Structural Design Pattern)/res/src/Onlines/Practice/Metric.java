package Onlines.Practice;

interface MetricSystem {
    double getTemperatureInCelsius();

    double getDistanceInMeters();
}

class ImperialSystemSensor {
    double getTemperatureInFahrenheit() {
        return 98.6;
    }

    double getDistanceInMiles() {
        return 1.0;
    }
}

class MetricAdapter implements MetricSystem {
    private ImperialSystemSensor sensor;

    public MetricAdapter() {
        sensor = new ImperialSystemSensor();
    }

    @Override
    public double getTemperatureInCelsius() {
        return (sensor.getTemperatureInFahrenheit() - 32) * 5 / 9;
    }

    @Override
    public double getDistanceInMeters() {
        return sensor.getDistanceInMiles() * 1609.34;
    }

}

public class Metric {
    public static void main(String[] args) {
        MetricSystem metricSystem = new MetricAdapter();
        System.out.println("Temperature in Celsius: " + metricSystem.getTemperatureInCelsius());
        System.out.println("Distance in Meters: " + metricSystem.getDistanceInMeters());
    }
}
