package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

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

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showMenu(v);

            }
        });

    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Kickoff_Descriptions.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.appInfo)
                    Toast.makeText(Kickoff_Descriptions.this, "You clicked app info", Toast.LENGTH_SHORT).show();
                return true;


            }
        });
        popupMenu.show();
    }
}