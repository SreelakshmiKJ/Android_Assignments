public class SyncWorker extends Worker {
    public SyncWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        WeatherRepository repo = new WeatherRepository(getApplicationContext());
        repo.fetchAndStoreWeather();
        return Result.success();
    }
}