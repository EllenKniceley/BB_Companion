package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class NuffleTableDescriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuffle_table_descriptions);

        String number = getIntent().getStringExtra("NUMBER");
        String title = getIntent().getStringExtra("TITLE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView nuffleTableNumber = findViewById(R.id.nuffleTableNumbers2);
        TextView nuffleTableTitle = findViewById(R.id.nuffleTableHeaders2);
        TextView nuffleTableDescription = findViewById(R.id.nuffleTableDescriptions);

        nuffleTableNumber.setText(number);
        nuffleTableTitle.setText(title);
        nuffleTableDescription.setText(description);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String nuffleTitle = "Nuffle Table (1D16)";
        menuTitle.setText(nuffleTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(NuffleTableDescriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(NuffleTableDescriptions.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()==R.id.appHome){
                Intent intent = new Intent(NuffleTableDescriptions.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
}