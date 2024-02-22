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

public class Lasting_Roll_Main extends AppCompatActivity implements LastingRollRecyclerViewInterface {

    ArrayList<LastingRollListModel> lastingRollListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lasting_roll_main);

        RecyclerView recyclerView = findViewById(R.id.lastingRollRecyclerView);

        setUpLastingRollListModels();
        LastingRollRecyclerViewAdapter adapter = new LastingRollRecyclerViewAdapter(this, lastingRollListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String lastingRollTitle = "Lasting Injury Roll (1D6)";
        menuTitle.setText(lastingRollTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Lasting_Roll_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(Lasting_Roll_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome){
                Intent intent = new Intent(Lasting_Roll_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    private void setUpLastingRollListModels() {
        String[] lastingRollNumbers = getResources().getStringArray(R.array.lastingRollNumbers);
        String[] lastingRollHeaders = getResources().getStringArray(R.array.lastingRollHeaders);
        String[] lastingRollDescriptions = getResources().getStringArray(R.array.lastingRollDescriptions);

        for (int i = 0; i<lastingRollNumbers.length; i++){
            lastingRollListModels.add(new LastingRollListModel(lastingRollNumbers[i],lastingRollHeaders[i],lastingRollDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Lasting_Roll_Main.this, LastingRollDescriptions.class);

        intent.putExtra("NUMBER", lastingRollListModels.get(position).getLastingRollNumber());
        intent.putExtra("TITLE", lastingRollListModels.get(position).getLastingRollTitle());
        intent.putExtra("DESCRIPTION", lastingRollListModels.get(position).getLastingRollDescription());

        startActivity(intent);
    }
}