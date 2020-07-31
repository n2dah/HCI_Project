package com.example.hci_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {

    ArrayList<Charities> items;
    public MyAdapter(Context context, int layout, ArrayList<Charities> items){

        super(context, layout);
        this.items = items;
    }

    public void update(ArrayList<Charities> results){
        items = new ArrayList<>();
        items.addAll(results);
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView textView2;
        CheckBox checkView;
    }

    @Override
    public int getCount() {
        return items.size();
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        ViewHolder viewHolder;
        if(row == null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.my_list_item,parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = row.findViewById(R.id.CharityImage);
            viewHolder.textView = row.findViewById(R.id.CharityName);
            viewHolder.textView2 = row.findViewById(R.id.CharityDisease);
            viewHolder.checkView = row.findViewById(R.id.savedCharity);

            row.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) row.getTag();
        }

        viewHolder.imageView.setImageResource(items.get(position).image);
        viewHolder.textView.setText(items.get(position).charityName);
        viewHolder.textView2.setText(items.get(position).charityDisease);
        viewHolder.checkView.setChecked(items.get(position).savedCharity);



        return row;
    }
}
