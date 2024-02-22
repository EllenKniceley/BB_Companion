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

public class Nuffle_Table_Main extends AppCompatActivity implements NuffleTableRecyclerViewInterface {

    ArrayList<NuffleTableListModel> nuffleTableListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuffle_table_main);

        RecyclerView recyclerView = findViewById(R.id.nuffleRecyclerView);

        setUpNuffleTableListModels();
        NuffleTableRecyclerViewAdapter adapter = new NuffleTableRecyclerViewAdapter(this, nuffleTableListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String nuffleTitle = "Nuffle Table (1D16)";
        menuTitle.setText(nuffleTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Nuffle_Table_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(Nuffle_Table_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if (item.getItemId()==R.id.appHome){
                Intent intent = new Intent(Nuffle_Table_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    private void setUpNuffleTableListModels() {
        String[] nuffleTableNumbers = getResources().getStringArray(R.array.nuffleTableNumbers);
        String[] nuffleTableHeaders = getResources().getStringArray(R.array.nuffleTableHeaders);
        String[] nuffleTableDescriptions = getResources().getStringArray(R.array.nuffleTableDescriptions);

        for (int i = 0; i<nuffleTableNumbers.length; i++){
            nuffleTableListModels.add(new NuffleTableListModel(nuffleTableNumbers[i],nuffleTableHeaders[i],nuffleTableDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Nuffle_Table_Main.this, NuffleTableDescriptions.class);

        intent.putExtra("NUMBER", nuffleTableListModels.get(position).getNuffleTableNumber());
        intent.putExtra("TITLE", nuffleTableListModels.get(position).getNuffleTableTitle());
        intent.putExtra("DESCRIPTION", nuffleTableListModels.get(position).getNuffleTableDescription());

        startActivity(intent);
    }
}