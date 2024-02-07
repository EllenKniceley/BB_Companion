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

public class Kickoff_table_main extends AppCompatActivity implements KickoffRecyclerViewInterface {

    ArrayList<KickoffListModel> kickoffListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kickoff_table_main);

        RecyclerView recyclerView = findViewById(R.id.kickoffRecyclerView);

        setUpKickoffListModels();
        Kickoff_RecyclerViewAdapter adapter = new Kickoff_RecyclerViewAdapter(this, kickoffListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String kickoffTable = "Kickoff Table";
        title.setText(kickoffTable);

        menuIcon.setOnClickListener(this::showMenu);
    }

    private void setUpKickoffListModels() {
        String[] kickoffNumbers = getResources().getStringArray(R.array.kickoff_headers_numbers);
        String[] kickoffHeaders = getResources().getStringArray(R.array.kickoff_headers);
        String[] kickoffDescriptions = getResources().getStringArray(R.array.kickoff_descriptions);

        for (int i = 0; i<kickoffNumbers.length; i++){
            kickoffListModels.add(new KickoffListModel(kickoffNumbers[i],kickoffHeaders[i], kickoffDescriptions[i]));
        }
    }

    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(Kickoff_table_main.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()==R.id.appInfo) {
                Intent intent = new Intent(Kickoff_table_main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Intent intent = new Intent(Kickoff_table_main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Kickoff_table_main.this, Kickoff_Descriptions.class);

        intent.putExtra("NUMBER", kickoffListModels.get(position).getKickoffNumber());
        intent.putExtra("TITLE", kickoffListModels.get(position).getKickoffTitle());
        intent.putExtra("DESCRIPTION", kickoffListModels.get(position).getKickoffDescription());

        startActivity(intent);

    }
}