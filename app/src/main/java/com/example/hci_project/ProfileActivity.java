package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    public static boolean PROFILE_CHANGE;
    boolean loggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        loggedIn = extras.getBoolean("AUTH");


        if (loggedIn){
            //Toast.makeText(getApplicationContext(), "Your logged in.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "You're NOT logged in.", Toast.LENGTH_SHORT).show();
        }

        Button btnGoBack = findViewById(R.id.btn_goBack);
        Button btnSignOff = findViewById(R.id.btnSignOff);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("AUTH_CH",loggedIn);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
        btnSignOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loggedIn = false;
                Toast.makeText(getApplicationContext(), "You've logged off successfully.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}