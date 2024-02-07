package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Kickoff_Descriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kickoff_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView kickoffNumber = findViewById(R.id.kickoffNumbers2);
        TextView kickoffTitle = findViewById(R.id.kickoffHeader2);
        TextView kickoffDescription = findViewById(R.id.kickoffDescriptions);

        kickoffNumber.setText(number);
        kickoffTitle.setText(title);
        kickoffDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String kickoffTable = "Kickoff Table";
        menuTitle.setText(kickoffTable);

        menuIcon.setOnClickListener(this::showMenu);

    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Kickoff_Descriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.appInfo) {
                Intent intent = new Intent(Kickoff_Descriptions.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()== R.id.appHome) {
                Intent intent = new Intent(Kickoff_Descriptions.this, MainActivity.class);
                startActivity(intent);
            }
            return true;


        });
        popupMenu.show();
    }
}