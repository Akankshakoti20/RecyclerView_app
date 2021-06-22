package com.example.recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfilesActivity extends AppCompatActivity {
    private TextView firstName,lastName,position,country;
    private ImageView profileImage;
    private Button backButton;
    private int position_variable;
    ModelClass[] players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);


        firstName=findViewById(R.id.profileFName);
        lastName=findViewById(R.id.profileLName);
        country=findViewById(R.id.profileCountry);
        position=findViewById(R.id.profilePosition);
        profileImage=findViewById(R.id.profileImage);
        backButton=findViewById(R.id.profileBtnBack);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
           players=(ModelClass[])extras.getSerializable("obj");
            position_variable=extras.getInt("pos");
        }
        firstName.setText(players[position_variable].firstName);
        lastName.setText(players[position_variable].lastName);
        position.setText(players[position_variable].position);
        country.setText(players[position_variable].country);
        int redID=getResources().getIdentifier(players[position_variable].largeImg,"mipmap",getPackageName());
        profileImage.setImageBitmap(BitmapFactory.decodeResource(getResources(),redID));

        //Backbutton

        backButton.setOnClickListener((v) ->{
            Intent i=new Intent(ProfilesActivity.this,TeamActivity.class);
            i.putExtra("obj",players);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.putExtra("EXIT",true);
            startActivity(i);
            finish();
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.edit_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if( item.getItemId() == R.id.editDetails ){
           Intent editdetails=new Intent(getApplicationContext(),EditDetailsActivity.class);
           editdetails.putExtra("obj",players).putExtra("pos",position_variable);
           startActivity(editdetails);
       }
        return super.onOptionsItemSelected(item);
    }

}