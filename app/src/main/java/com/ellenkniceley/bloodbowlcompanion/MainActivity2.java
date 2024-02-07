package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

// Weather Table

public class MainActivity2 extends AppCompatActivity implements WeatherRecyclerViewInterface{

    ArrayList<WeatherListModel> weatherListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.weatherRecyclerView);

        setUpWeatherListModels();

        Weather_RecyclerViewAdapter adapter = new Weather_RecyclerViewAdapter(this, weatherListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String weatherTable = "Weather Table";
        title.setText(weatherTable);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void setUpWeatherListModels() {
        String[] weatherNumbers = getResources().getStringArray(R.array.weather_headers_numbers);
        String[] weatherTitles = getResources().getStringArray(R.array.weather_titles);
        String[] weatherDescription = getResources().getStringArray(R.array.weather_descriptions);

        for (int i = 0; i<weatherNumbers.length; i++){
            weatherListModels.add(new WeatherListModel(weatherNumbers[i], weatherTitles[i], weatherDescription[i]));
        }
    }

    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(MainActivity2.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()== R.id.appInfo) {
                Intent intent = new Intent(MainActivity2.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity2.this, Weather_Descriptions.class);

        intent.putExtra("NUMBER", weatherListModels.get(position).getWeatherNumber());
        intent.putExtra("TITLE", weatherListModels.get(position).getWeatherTitle());
        intent.putExtra("DESCRIPTION", weatherListModels.get(position).getWeatherDescription());

        startActivity(intent);
    }
}