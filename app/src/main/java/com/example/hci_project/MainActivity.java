package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Quick Search text transfer
    public static final String EXTRA_MESSAGE = " ";
    String myQuery = "N/A";

    //Initialize user
    //Users sampleUser = new Users("david",);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void refinedSearchButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
    public void savedSearchButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),SavedSearchActivity.class);
        startActivity(i);
    }

    //User clicks on the "Quick Search" button
    public void SearchButtonOnClick(View v){
        TextView textView = (TextView)findViewById(R.id.tv_mainSearch);
        myQuery = textView.getText().toString();
        Intent i = new Intent(getApplicationContext(),SearchActivity.class);
        i.putExtra(EXTRA_MESSAGE, myQuery);
        startActivity(i);
    }
    public void profileButtonOnClick(View v){

        Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(i);
    }
    public void infoButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(i);
    }
    public void charityButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(i);
    }
}