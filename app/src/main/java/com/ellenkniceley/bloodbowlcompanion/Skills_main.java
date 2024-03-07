package com.ellenkniceley.bloodbowlcompanion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class Skills_main extends AppCompatActivity implements SkillsRecyclerViewInterface {

    ArrayList<SkillsListModel> skillsListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_main);

        RecyclerView recyclerView = findViewById(R.id.skillsRecyclerView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar !=null){
        setSupportActionBar(toolbar);}

        setUpSkillsListModels();
        SkillsRecyclerViewAdapter adapter = new SkillsRecyclerViewAdapter(this, skillsListModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.toolbar_title);
        String skillsTable = "Skills";
        title.setText(skillsTable);

        menuIcon.setOnClickListener(this::showMenu);


    }

    private void setUpSkillsListModels() {
        String[] skillsHeaders = getResources().getStringArray(R.array.skillHeaders);
        String[] skillDescriptions = getResources().getStringArray(R.array.skillDescriptions);

        for (int i = 0; i < skillsHeaders.length; i++) {
            skillsListModels.add(new SkillsListModel(skillsHeaders[i],skillDescriptions[i]));
        }
    }

    private void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(Skills_main.this,v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if(item.getItemId()== R.id.appInfo) {
                Intent intent = new Intent(Skills_main.this, App_Info_Page.class);
                startActivity(intent);
            }
            if(item.getItemId()==R.id.appHome) {
                Intent intent = new Intent(Skills_main.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Skills_main.this, SkillsDescriptions.class);

        intent.putExtra("TITLE", skillsListModels.get(position).getSkillsTitle());
        intent.putExtra("DESCRIPTION", skillsListModels.get(position).getSkillsDescription());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        assert searchView != null;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}