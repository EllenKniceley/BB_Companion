package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class StuntyRollDescriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stunty_roll_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView stuntyRollNumber = findViewById(R.id.stuntyRollNumbers2);
        TextView stuntyRollTitle = findViewById(R.id.stuntyRollHeaders2);
        TextView stuntyRollDescription = findViewById(R.id.stuntyRollDescriptions);

        stuntyRollNumber.setText(number);
        stuntyRollTitle.setText(title);
        stuntyRollDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String stuntyRollToolbarTitle = "Stunty Roll (2D6)";
        menuTitle.setText(stuntyRollToolbarTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(StuntyRollDescriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(StuntyRollDescriptions.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()==R.id.appHome){
                Intent intent = new Intent(StuntyRollDescriptions.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
}