package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Quick Search text transfer
    public static final String EXTRA_MESSAGE = " ";
    String myQuery = "N/A";

    //Initialize user
    ArrayList<Charities> userArray = new ArrayList<>();
    Users sampleUser = new Users("Lacey",userArray,1, true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (sampleUser.isLoggedIn() == true){
            TextView textView = findViewById(R.id.tv_userName);
            textView.setText("Hello " + sampleUser.getName().toString());
        }

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
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        i.putExtra("name", sampleUser.getName());
        i.putExtra("image", sampleUser.getProfilePic());
        i.putExtra("loggedIn", sampleUser.isLoggedIn());
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