package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class CasualtyRollDescriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casualty_roll_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView casualtyRollNumber = findViewById(R.id.casualtyRollNumbers2);
        TextView casualtyRollTitle = findViewById(R.id.casualtyRollHeaders2);
        TextView casualtyRollDescription = findViewById(R.id.casualtyRollDescriptions);

        casualtyRollNumber.setText(number);
        casualtyRollTitle.setText(title);
        casualtyRollDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String casualtyRollToolbarTitle = "Casualty Roll (1D16)";
        menuTitle.setText(casualtyRollToolbarTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(CasualtyRollDescriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(CasualtyRollDescriptions.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()==R.id.appHome){
                Intent intent = new Intent(CasualtyRollDescriptions.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
}