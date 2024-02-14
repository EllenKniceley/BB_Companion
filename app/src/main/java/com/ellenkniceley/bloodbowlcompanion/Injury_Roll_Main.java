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

public class Injury_Roll_Main extends AppCompatActivity implements InjuryRollRecyclerViewInterface {

    ArrayList<InjuryRollListModel> injuryRollListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_roll_main);

        RecyclerView recyclerView = findViewById(R.id.injuryRollRecyclerView);

        setUpInjuryRollListModels();
        InjuryRollRecyclerViewAdapter adapter = new InjuryRollRecyclerViewAdapter(this, injuryRollListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String injuryRollTitle = "Injury Roll (2D6)";
        title.setText(injuryRollTitle);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(Injury_Roll_Main.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo){
                Intent intent =  new Intent(Injury_Roll_Main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome){
                Intent intent = new Intent(Injury_Roll_Main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    private void setUpInjuryRollListModels() {
        String[] injuryRollNumbers = getResources().getStringArray(R.array.injuryRollNumbers);
        String[] injuryRollHeaders = getResources().getStringArray(R.array.injuryRollHeaders);
        String[] injuryRollDescriptions = getResources().getStringArray(R.array.injuryRollDescriptions);

        for (int i = 0; i<injuryRollNumbers.length; i++){
            injuryRollListModels.add(new InjuryRollListModel(injuryRollNumbers[i],injuryRollHeaders[i],injuryRollDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Injury_Roll_Main.this, InjuryRollDescriptions.class);

        intent.putExtra("NUMBER", injuryRollListModels.get(position).getInjuryRollNumber());
        intent.putExtra("TITLE", injuryRollListModels.get(position).getInjuryRollTitle());
        intent.putExtra("DESCRIPTION", injuryRollListModels.get(position).getInjuryRollDescription());

        startActivity(intent);

    }
}