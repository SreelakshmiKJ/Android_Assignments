public class WeatherAdapter extends ListAdapter<WeatherEntity, WeatherAdapter.ViewHolder> {
    protected WeatherAdapter() {
        super(new DiffUtil.ItemCallback<WeatherEntity>() {
            public boolean areItemsTheSame(@NonNull WeatherEntity a, @NonNull WeatherEntity b) {
                return a.id == b.id;
            }
            public boolean areContentsTheSame(@NonNull WeatherEntity a, @NonNull WeatherEntity b) {
                return a.equals(b);
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView temp, humid, cond;
        ViewHolder(View v) {
            super(v);
            temp = v.findViewById(R.id.temp);
            humid = v.findViewById(R.id.humid);
            cond = v.findViewById(R.id.cond);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherEntity item = getItem(position);
        holder.temp.setText("Temp: " + item.temperature);
        holder.humid.setText("Humidity: " + item.humidity);
        holder.cond.setText(item.condition);
    }
}
