@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherEntity entity);

    @Query("SELECT * FROM weather WHERE timestamp >= :from ORDER BY timestamp DESC")
    List<WeatherEntity> getWeeklyData(long from);
}