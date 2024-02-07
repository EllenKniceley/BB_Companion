package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class App_Info_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info_page);

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String appInfo = "App Info";
        title.setText(appInfo);

        menuIcon.setOnClickListener(this::showMenu);
    }
    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(App_Info_Page.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()== R.id.appInfo)
                Toast.makeText(App_Info_Page.this, "You are already on the App Info page.", Toast.LENGTH_SHORT).show();
            return true;


        });
        popupMenu.show();
    }
}