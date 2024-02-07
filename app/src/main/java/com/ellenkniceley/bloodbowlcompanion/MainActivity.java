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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainList_RecyclerViewAdapter.OnItemListener{

    ArrayList<ListModel> listModels = new ArrayList<>();

    int[] listImages = {R.drawable.baseline_cloud_24, R.drawable.baseline_sports_football_24, R.drawable.baseline_construction_24,
                        R.drawable.baseline_sports_martial_arts_24, R.drawable.baseline_arrow_outward_24, R.drawable.baseline_back_hand_24, R.drawable.baseline_local_pharmacy_24, R.drawable.baseline_casino_24};
    int[] type = {0, 1, 2, 3, 4, 5, 6, 7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        ImageView menuIcon = findViewById(R.id.menu_icon);

        menuIcon.setOnClickListener(this::showMenu);

        setUpListModels();

        MainList_RecyclerViewAdapter adapter = new MainList_RecyclerViewAdapter(this, listModels, this, type);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpListModels () {
        String[] listNames = getResources().getStringArray(R.array.list_headers);

        for (int i = 0; i<listNames.length; i++) {
            listModels.add(new ListModel(listNames[i],
            listImages[i]));
        }
    }

    private static final String TAG = "MainActivity";
    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick: ");
    }
    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()== R.id.appInfo) {
                Intent intent = new Intent(MainActivity.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Toast.makeText(this, "You are already on the Home screen.", Toast.LENGTH_SHORT).show();
            }
             return true;


        });
        popupMenu.show();
    }
}

