package com.ellenkniceley.bloodbowlcompanion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Weather_RecyclerViewAdapter extends RecyclerView.Adapter<Weather_RecyclerViewAdapter.MyViewHolder> {
    private final WeatherRecyclerViewInterface weatherRecyclerViewInterface;
    Context context;
    ArrayList<WeatherListModel> weatherListModels;

    public Weather_RecyclerViewAdapter(Context context, ArrayList<WeatherListModel> weatherListModels, WeatherRecyclerViewInterface weatherRecyclerViewInterface){
        this.context = context;
        this.weatherListModels = weatherListModels;
        this.weatherRecyclerViewInterface = weatherRecyclerViewInterface;
    }

    @NonNull
    @Override
    public Weather_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to the rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.weather_recyclerview_row, parent, false);
        return new Weather_RecyclerViewAdapter.MyViewHolder(view, weatherRecyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Weather_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the weather_recyclerview_row file
        // based on the position of the recyclerview
        holder.tvWeatherNumber.setText(weatherListModels.get(position).getWeatherNumber());
        holder.tvWeatherTitle.setText(weatherListModels.get(position).getWeatherTitle());
    }

    @Override
    public int getItemCount() {
        // wants to know the number of items you want displayed
        return weatherListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabs views from weather_recyclerview_row layout file

        TextView tvWeatherNumber;
        TextView tvWeatherTitle;
        public MyViewHolder(@NonNull View itemView, WeatherRecyclerViewInterface weatherRecyclerViewInterface) {
            super(itemView);

            tvWeatherNumber = itemView.findViewById(R.id.textView2);
            tvWeatherTitle = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (weatherRecyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            weatherRecyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
