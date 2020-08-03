package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CharityInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_info);
    }
    public void refinedSearchButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
}