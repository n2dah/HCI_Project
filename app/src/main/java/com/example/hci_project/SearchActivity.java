package com.example.hci_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;

    //holds the charity names
    String mTitle[] = {"Children's Leukemia Foundation of Michigan", "Leukemia Research Foundation",
            "AIDS Foundation Houston","Desert AIDS Project", "San Francisco AIDS Foundation",
            "Mesothelioma Applied Research Foundation"};

    //holds the description information aka the charity tags (diseases)
    String mDescription[] = {"Leukemia","Leukemia",
            "AIDS","AIDS","AIDS",
            "Mesothelioma"};

    //charity image
    int images[] = {R.drawable.holdinghands, R.drawable.clouds, R.drawable.offwhite, R.drawable.offwhite, R.drawable.offwhite, R.drawable.offwhite};

    boolean checked[] = {true, true, false, false, true, false};

    //ArrayList<String> list1;
    ArrayAdapter adapter;


    //testing transition code
    public void infoButtonOnClick(View v){
        Intent i = new Intent(getApplicationContext(),InfoActivity.class);
        startActivity(i);
    }

    //testing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.search_bar);
        listView = findViewById(R.id.listView);

        //custom adapter
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images, checked);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(SearchActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                    //transition to charity content
                }
                if (position == 1){
                    Toast.makeText(SearchActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(SearchActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(SearchActivity.this, "facebook", Toast.LENGTH_SHORT).show();
                }
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                SearchActivity.this.adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                SearchActivity.this.adapter.getFilter().filter(s);
                return false;
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        boolean rCheck[];

        MyAdapter (Context c, String title[], String description[], int imgs[], boolean check[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
            this.rCheck = check;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            CheckBox checks = row.findViewById(R.id.checkBox);

            checks.setChecked(rCheck[position]);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}