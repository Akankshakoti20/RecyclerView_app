package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDetailsActivity extends AppCompatActivity {
    private EditText fname, lname, country, pos;
    private ModelClass[] players;
    private Button submit;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            players = (ModelClass[]) extras.getSerializable("obj");
            position = extras.getInt("pos");
        }

        fname = findViewById(R.id.editFirstName);
        lname = findViewById(R.id.editLastName);
        pos = findViewById(R.id.editPosition);
        country = findViewById(R.id.editCountry);
        submit = findViewById(R.id.btnSave);

        fname.setText(players[position].firstName);
        lname.setText(players[position].lastName);
        pos.setText(players[position].position);
        country.setText(players[position].country);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                players[position].firstName = fname.getText().toString();
                players[position].lastName = lname.getText().toString();
                players[position].position = pos.getText().toString();
                players[position].country = country.getText().toString();

                Intent intent = new Intent(getApplicationContext(),ProfilesActivity.class);
                intent.putExtra("obj",players).putExtra("pos",position);
                startActivity(intent);
                finish();

            }
        });










    }
}