package com.example.visitetechnique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DateAdapter extends ArrayAdapter<Dates> {
    public DateAdapter(Context context, ArrayList<Dates> dateList){
        super(context, 0, dateList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View converView, ViewGroup parent){
        if (converView == null){
            converView = LayoutInflater.from(getContext()).inflate(
                    R.layout.date_spinner_row,
                    parent,
                    false
            );
        }

        TextView textViewName = converView.findViewById(R.id.textV);

        Dates currentItem = getItem(position);
        if (currentItem != null) {
            textViewName.setText(currentItem.getDate().toString());
        }
        return converView;
    }
}
