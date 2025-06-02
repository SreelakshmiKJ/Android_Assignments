public class WeatherApiService {
    public WeatherEntity fetchWeather() {
        WeatherEntity mock = new WeatherEntity();
        mock.temperature = 25 + (float)(Math.random() * 10);
        mock.humidity = 40 + (int)(Math.random() * 30);
        mock.condition = "Sunny";
        mock.timestamp = System.currentTimeMillis();
        return mock;
    }
}