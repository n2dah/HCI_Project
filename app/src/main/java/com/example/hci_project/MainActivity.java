package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = " ";
    String numType = "N/A";

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
    public void SearchButtonOnClick(View v){
        TextView textView = (TextView)findViewById(R.id.tv_mainSearch);
        numType = textView.getText().toString();
        Intent i = new Intent(getApplicationContext(),SearchActivity.class);
        i.putExtra(EXTRA_MESSAGE, numType);
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