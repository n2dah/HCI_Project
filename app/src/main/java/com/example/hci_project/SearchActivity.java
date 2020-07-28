package com.example.hci_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView sv;
    ListView lv;
    ArrayList<String> list1;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        lv = (ListView)findViewById(R.id.list);
        sv = (SearchView)findViewById(R.id.search);
        list1 = new ArrayList<String>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list1);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}