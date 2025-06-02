public class WeatherViewModel extends AndroidViewModel {
    private final WeatherRepository repo;
    public LiveData<List<WeatherEntity>> weeklyWeather;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        repo = new WeatherRepository(application);
        weeklyWeather = repo.getWeeklyWeather();
    }

    public void refreshWeather() {
        repo.fetchAndStoreWeather();
    }
}
