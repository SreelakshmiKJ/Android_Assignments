public class MainActivity extends AppCompatActivity {
    private WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        ScheduleSync.setupPeriodicSync(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        WeatherAdapter adapter = new WeatherAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.weeklyWeather.observe(this, data -> adapter.submitList(data));

        findViewById(R.id.refreshButton).setOnClickListener(v -> viewModel.refreshWeather());
    }
}