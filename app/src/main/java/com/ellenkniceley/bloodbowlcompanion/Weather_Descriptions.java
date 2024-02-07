package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Weather_Descriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView weatherNumber = findViewById(R.id.weatherNumbers);
        TextView weatherTitle = findViewById(R.id.weatherTitles);
        TextView weatherDescription = findViewById(R.id.weatherDescriptions);

        weatherNumber.setText(number);
        weatherTitle.setText(title);
        weatherDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String weatherTable = "Weather Table";
        menuTitle.setText(weatherTable);

        menuIcon.setOnClickListener(this::showMenu);

    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Weather_Descriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.appInfo) {
                Intent intent = new Intent(Weather_Descriptions.this, App_Info_Page.class);
                startActivity(intent);
            }

            return true;


        });
        popupMenu.show();
    }
}