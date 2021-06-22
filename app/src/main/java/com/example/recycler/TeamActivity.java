package com.example.recycler;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TeamActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    ModelClass[] modelClasses = {

            new ModelClass("MS", "Dhoni", "Wicket-Keeeper", "India", "dhoni", "dhoni"),
            new ModelClass("AB De", "Villiers", "Wicket-Keeeper", "SouthAfrica", "abd", "abd"),
            new ModelClass("Virat", "Kohli", "Batsman", "India", "virat", "virat"),
            new ModelClass("Rahul", "Dravid", "Wicket-Keeeper", "India", "rahul", "rahul"),
            new ModelClass("Rohit", "Sharma", "Batsman", "India", "rohit", "rohit"),
            new ModelClass("Rishabh", "Pant", "Wicket-Keeeper", "India", "rishabh", "rishabh"),
            new ModelClass("Washington", "Sundar", "All-rounder", "India", "sundar", "sundar"),
            new ModelClass("KL", "Rahul", "Wicket-Keeeper", "India", "kl", "kl"),
            new ModelClass("Hardik", "Pandya", "All-Rounder", "India", "hardik", "hardik"),
            new ModelClass("Ravindra", "Jadeja", "All-Rounder", "India", "ravindra", "ravindra")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //used to create a back arrow on the action bar

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            modelClasses = (ModelClass[]) extra.getSerializable("obj");
        }
        recyclerView = findViewById(R.id.recyclerViewPlayer);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        TeamAdapter adapter=new TeamAdapter(modelClasses);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() { //function meant only for back arrow  in the toolbar
        Intent back = new Intent(TeamActivity.this, MainActivity.class);
        startActivity(back);
        return true;
    }
}