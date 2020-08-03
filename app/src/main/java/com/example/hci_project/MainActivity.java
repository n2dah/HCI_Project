package com.example.hci_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Quick Search text transfer
    public static final String EXTRA_MESSAGE = " ";
    String myQuery = "N/A";

    //Initialize user
    ArrayList<Charities> userArray = new ArrayList<>();
    Users sampleUser = new Users("Blanche",userArray,1, true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnProfile = findViewById(R.id.imgBtn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putBoolean("AUTH",sampleUser.isLoggedIn());
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                i.putExtras(extras);
                startActivityForResult(i, 1);
            }
        });

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
    public void infoButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(i);
    }
    public void charityButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                boolean loggedIn = data.getBooleanExtra("AUTH_CH",false);
                sampleUser.setLoggedIn(loggedIn);
            }
            if(resultCode == RESULT_CANCELED){
                //here
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sampleUser.isLoggedIn()){
            TextView textView = findViewById(R.id.tv_userName);
            textView.setText("Hello " + sampleUser.getName().toString());
        }
        else{
            TextView textView = findViewById(R.id.tv_userName);
            textView.setText("Hello Guest");

            Button btnSavedCharities = findViewById(R.id.btn_savedSearches);
            btnSavedCharities.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_baseline_folder_special_150_unauth,0,0);
            btnSavedCharities.setEnabled(false);
        }
    }
}