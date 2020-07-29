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
        items.add(new Charities("another", R.drawable.charity1));
        items.add(new Charities("something", R.drawable.charity2));
        items.add(new Charities("new", R.drawable.charity3));
        items.add(new Charities("caring", R.drawable.charity4));
        items.add(new Charities("affordable", R.drawable.charity5));
        items.add(new Charities("old", R.drawable.charity6));
        items.add(new Charities("another", R.drawable.charity7));
        items.add(new Charities("finding", R.drawable.charity8));
        items.add(new Charities("helping", R.drawable.charity9));
        items.add(new Charities("testing", R.drawable.holdinghands));


        listView.setAdapter(new MyAdapter(SearchActivity.this, R.layout.my_list_item, items));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Charities> results = new ArrayList<>();

                for (Charities x : items) {
                    if (x.charityName.contains((s))) {
                        results.add(x);
                    }
                }

                ((MyAdapter) listView.getAdapter()).update(results);

                return false;
            }
        });

    }


}