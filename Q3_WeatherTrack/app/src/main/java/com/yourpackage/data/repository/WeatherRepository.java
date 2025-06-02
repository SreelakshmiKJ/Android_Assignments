public class WeatherRepository {
    private final WeatherDao dao;
    private final WeatherApiService api;

    public WeatherRepository(Context context) {
        WeatherDatabase db = Room.databaseBuilder(context, WeatherDatabase.class, "weather_db").build();
        this.dao = db.weatherDao();
        this.api = new WeatherApiService();
    }

    public LiveData<List<WeatherEntity>> getWeeklyWeather() {
        long weekAgo = System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000;
        MutableLiveData<List<WeatherEntity>> data = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(() -> {
            data.postValue(dao.getWeeklyData(weekAgo));
        });
        return data;
    }

    public void fetchAndStoreWeather() {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                WeatherEntity weather = api.fetchWeather();
                dao.insert(weather);
            } catch (Exception e) {
                Log.e("WeatherRepository", "API fetch failed", e);
            }
        });
    }
}