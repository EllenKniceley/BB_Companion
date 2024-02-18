package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class Injury_Table_Main extends AppCompatActivity implements InjuryTableRecyclerViewInterface {

    ArrayList<InjuryTableListModel> injuryTableListModels = new ArrayList<>();

    int[] type = {0, 1, 2, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_table_main);

        RecyclerView recyclerView = findViewById(R.id.injuryTableRecyclerview);

        setUpInjuryListModels();
        Injury_Table_RecyclerViewAdapter adapter = new Injury_Table_RecyclerViewAdapter(this, injuryTableListModels, this, type);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String injuryTableHeader = "Injury/Casualty Table";
        title.setText(injuryTableHeader);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Injury_Table_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo) {
                Intent intent = new Intent(Injury_Table_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Intent intent = new Intent(Injury_Table_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
    public static final String TAG = "Injury_Table_Main";
    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick: ");
    }

    private void setUpInjuryListModels() {
        String[] injuryListTitle = getResources().getStringArray(R.array.injuryTableHeaderList);

        for (String s : injuryListTitle) {
            injuryTableListModels.add(new InjuryTableListModel(s));
        }
    }
}