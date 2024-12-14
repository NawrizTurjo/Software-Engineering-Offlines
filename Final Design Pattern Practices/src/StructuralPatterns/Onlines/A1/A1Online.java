package StructuralPatterns.Onlines.A1;

// Legacy Weather Service, which we cannot modify
class LegacyWeatherService {
    public String getWeatherData() {
        return "Legacy weather data";
    }
}

// Client Interface expected by the application
interface WeatherProvider {
    String fetchWeather();
}

// Application class that depends on the WeatherProvider interface
class WeatherApp {
    private WeatherProvider weatherProvider;

    public WeatherApp(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public void displayWeather() {
        System.out.println(weatherProvider.fetchWeather());
    }
}

class LegacyWeatherAdapter implements WeatherProvider {
    private LegacyWeatherService legacyWeatherService;

    public LegacyWeatherAdapter(LegacyWeatherService legacyWeatherService) {
        this.legacyWeatherService = legacyWeatherService;
    }

    @Override
    public String fetchWeather() {
        return legacyWeatherService.getWeatherData();
    }
}

public class A1Online {
    public static void main(String[] args) {
        // Legacy service instance
        LegacyWeatherService legacyWeatherService = new LegacyWeatherService();

        LegacyWeatherAdapter adapter = new LegacyWeatherAdapter(legacyWeatherService);

        WeatherApp app = new WeatherApp(adapter);
        app.displayWeather(); // Output: Legacy weather data
    }
}
