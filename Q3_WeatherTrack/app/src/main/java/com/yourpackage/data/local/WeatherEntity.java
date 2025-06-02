@Entity(tableName = "weather")
public class WeatherEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public float temperature;
    public int humidity;
    public String condition;
    public long timestamp;
}