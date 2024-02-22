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

public class Casualty_Roll_Main extends AppCompatActivity implements CasualtyRollRecyclerViewInterface {

    ArrayList<CasualtyRollListModel> casualtyRollListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casualty_roll_main);

        RecyclerView recyclerView = findViewById(R.id.casualtyRollRecyclerView);

        setUpCasualtyRollListModels();
        CasualtyRollRecyclerViewAdapter adapter = new CasualtyRollRecyclerViewAdapter(this, casualtyRollListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String casualtyRollTitle = "Casualty Roll (1D16)";
        menuTitle.setText(casualtyRollTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Casualty_Roll_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(Casualty_Roll_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome){
                Intent intent = new Intent(Casualty_Roll_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    private void setUpCasualtyRollListModels() {
        String[] casualtyRollNumbers = getResources().getStringArray(R.array.casualtyRollNumbers);
        String[] casualtyRollHeaders = getResources().getStringArray(R.array.casualtyRollHeaders);
        String[] casualtyRollDescriptions = getResources().getStringArray(R.array.casualtyRollDescriptions);

        for (int i = 0; i<casualtyRollNumbers.length; i++){
            casualtyRollListModels.add(new CasualtyRollListModel(casualtyRollNumbers[i],casualtyRollHeaders[i],casualtyRollDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Casualty_Roll_Main.this, CasualtyRollDescriptions.class);

        intent.putExtra("NUMBER", casualtyRollListModels.get(position).getCasualtyRollNumber());
        intent.putExtra("TITLE", casualtyRollListModels.get(position).getCasualtyRollTitle());
        intent.putExtra("DESCRIPTION", casualtyRollListModels.get(position).getCasualtyRollDescription());

        startActivity(intent);
    }
}