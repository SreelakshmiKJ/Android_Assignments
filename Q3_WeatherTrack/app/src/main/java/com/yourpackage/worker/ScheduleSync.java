public class ScheduleSync {
    public static void setupPeriodicSync(Context context) {
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(SyncWorker.class, 6, TimeUnit.HOURS).build();
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("weather_sync", ExistingPeriodicWorkPolicy.KEEP, request);
    }
}