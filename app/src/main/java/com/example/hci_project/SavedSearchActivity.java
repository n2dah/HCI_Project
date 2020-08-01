package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedSearchActivity extends AppCompatActivity {

    ArrayList<Charities> items = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_search);

        Intent intent = getIntent();

        final ListView listView = findViewById(R.id.lv_savedSearch);
        items.add(new Charities("Luther's Help", R.drawable.charity1, "tuberous sclerosis",true));
        items.add(new Charities("American Association", R.drawable.charity2,"lupus",true));

        listView.setAdapter(new MyAdapter(SavedSearchActivity.this, R.layout.my_list_item, items));
    }

    public void mainActivitybuttonOnclick(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}