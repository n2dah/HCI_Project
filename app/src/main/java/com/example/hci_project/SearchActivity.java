package com.example.hci_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Charities> items = new ArrayList<>();
    ListView listView;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.search_bar);
        final ListView listView = findViewById(R.id.myList);
        items.add(new Charities("Luther's Help", R.drawable.charity1, "Tuberous Sclerosis",true));
        items.add(new Charities("American Association", R.drawable.charity2,"Lupus",false));
        items.add(new Charities("Help in Need", R.drawable.charity3,"AIDS",true));
        items.add(new Charities("There4U", R.drawable.charity4,"Mesothelioma",true));
        items.add(new Charities("Skyward", R.drawable.charity5,"Mesothelioma",false));
        items.add(new Charities("Path of Light", R.drawable.charity6,"AIDS",true));
        items.add(new Charities("Solutions", R.drawable.charity7,"Leukemia",true));
        items.add(new Charities("SAVE", R.drawable.charity8,"AIDS",true));
        items.add(new Charities("Family Matters", R.drawable.charity9,"Lupus",false));
        items.add(new Charities("Peace Finder", R.drawable.holdinghands,"Mesothelioma",true));

        listView.setAdapter(new MyAdapter(SearchActivity.this, R.layout.my_list_item, items));


        //--

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),CharityInfoActivity.class);
                startActivity(intent);
            }
        });

        //---



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Charities> results = new ArrayList<>();

                for (Charities x : items) {
                    if (x.charityDisease.contains((s))) {
                        results.add(x);
                    }
                }

                ((MyAdapter) listView.getAdapter()).update(results);

                return false;
            }
        });

    }


}