package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void savedSearchButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),SavedSearchActivity.class);
        startActivity(i);
    }
    public void searchButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
    public void profileButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(i);
    }
}