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

public class Foul_Table_Main extends AppCompatActivity implements FoulRecyclerViewInterface {

    ArrayList<FoulListModel> foulListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foul_table_main);

        RecyclerView recyclerView = findViewById(R.id.foulTableRecyclerview);

        setUpFoulListModels();
        Foul_RecyclerViewAdapter adapter = new Foul_RecyclerViewAdapter(this, foulListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String foulTable = "Foul Table (1D6)";
        title.setText(foulTable);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Foul_Table_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo) {
                Intent intent = new Intent(Foul_Table_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Intent intent = new Intent(Foul_Table_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
                });
        popupMenu.show();
    }

    private void setUpFoulListModels() {
        String[] foulNumbers = getResources().getStringArray(R.array.foul_numbers);
        String[] foulHeaders = getResources().getStringArray(R.array.foul_headers);
        String[] foulDescriptions = getResources().getStringArray(R.array.foul_descriptions);

        for (int i = 0; i<foulNumbers.length; i++){
            foulListModels.add(new FoulListModel(foulNumbers[i],foulHeaders[i],foulDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Foul_Table_Main.this, Foul_Descriptions.class);

        intent.putExtra("NUMBER", foulListModels.get(position).getFoulNumber());
        intent.putExtra("TITLE", foulListModels.get(position).getFoulTitle());
        intent.putExtra("DESCRIPTION", foulListModels.get(position).getFoulDescription());

        startActivity(intent);
    }
}