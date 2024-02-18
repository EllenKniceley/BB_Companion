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

public class Stunty_Roll_Main extends AppCompatActivity implements StuntyRollRecyclerViewInterface {

    ArrayList<StuntyRollListModel> stuntyRollListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stunty_roll_main);

        RecyclerView recyclerView = findViewById(R.id.stuntyRollRecyclerView);

        setUpStuntyRollListModels();
        StuntyRollRecyclerViewAdapter adapter = new StuntyRollRecyclerViewAdapter(this, stuntyRollListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView menuTitle = findViewById(R.id.toolbar_title);
        String stuntyRollTitle = "Stunty Roll (2D6)";
        menuTitle.setText(stuntyRollTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Stunty_Roll_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo){
                Intent intent = new Intent(Stunty_Roll_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome){
                Intent intent = new Intent(Stunty_Roll_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    private void setUpStuntyRollListModels() {
        String[] stuntyRollNumbers = getResources().getStringArray(R.array.stuntyRollNumbers);
        String[] stuntyRollHeaders = getResources().getStringArray(R.array.stuntyRollHeaders);
        String[] stuntyRollDescriptions = getResources().getStringArray(R.array.stuntyRollDescriptions);

        for (int i = 0; i<stuntyRollNumbers.length; i++){
            stuntyRollListModels.add(new StuntyRollListModel(stuntyRollNumbers[i],stuntyRollHeaders[i],stuntyRollDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
       Intent intent = new Intent(Stunty_Roll_Main.this, StuntyRollDescriptions.class);

       intent.putExtra("NUMBER", stuntyRollListModels.get(position).getStuntyRollNumber());
       intent.putExtra("TITLE", stuntyRollListModels.get(position).getStuntyRollTitle());
       intent.putExtra("DESCRIPTION", stuntyRollListModels.get(position).getStuntyRollDescription());

       startActivity(intent);
    }
}