package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class LastingRollDescriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lasting_roll_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView lastingRollNumber = findViewById(R.id.lastingRollNumbers2);
        TextView lastingRollTitle = findViewById(R.id.lastingRollHeaders2);
        TextView lastingRollDescription = findViewById(R.id.lastingRollDescriptions);

        lastingRollNumber.setText(number);
        lastingRollTitle.setText(title);
        lastingRollDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String lastingRollToolbarTitle = "Lasting Injury Roll (1D6)";
        menuTitle.setText(lastingRollToolbarTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(LastingRollDescriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(LastingRollDescriptions.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()==R.id.appHome){
                Intent intent = new Intent(LastingRollDescriptions.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
}