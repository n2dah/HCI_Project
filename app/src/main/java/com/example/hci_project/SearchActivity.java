package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Charities> items = new ArrayList<>();
    ListView listView;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //MainActivity Data
        Intent intent = getIntent();
        String myQuery = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // SearchView Stuff
        searchView = findViewById(R.id.search_bar);
        searchView.setQuery(myQuery,false);

        final ListView listView = findViewById(R.id.myList);
        items.add(new Charities("Luther's Help", R.drawable.charity1, "tuberous sclerosis",true));
        items.add(new Charities("American Association", R.drawable.charity2,"lupus",false));
        items.add(new Charities("Help in Need", R.drawable.charity3,"AIDS",true));
        items.add(new Charities("There4U", R.drawable.charity4,"mesothelioma",true));
        items.add(new Charities("Skyward", R.drawable.charity5,"mesothelioma",false));
        items.add(new Charities("Path of Light", R.drawable.charity6,"AIDS",true));
        items.add(new Charities("Solutions", R.drawable.charity7,"leukemia",true));
        items.add(new Charities("SAVE", R.drawable.charity8,"AIDS",true));
        items.add(new Charities("Family Matters", R.drawable.charity9,"lupus",false));
        items.add(new Charities("Peace Finder", R.drawable.holdinghands,"mesothelioma",true));

        listView.setAdapter(new MyAdapter(SearchActivity.this, R.layout.my_list_item, items));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                onQueryTextChange(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Charities> results = new ArrayList<>();

                for (Charities x : items) {
                    if (x.charityDisease.contains(s)){
                        results.add(x);
                    }
                }

                ((MyAdapter) listView.getAdapter()).update(results);

                return false;
            }
        });

    }


}