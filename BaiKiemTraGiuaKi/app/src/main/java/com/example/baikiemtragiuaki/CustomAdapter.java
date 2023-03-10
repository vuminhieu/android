package com.example.baikiemtragiuaki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<CaSi> {
    private Context context;
    private int resource;
    private List<CaSi> caSiList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<CaSi> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.caSiList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dong_bai_hat, parent,false);

            viewHolder.textViewTen = convertView.findViewById(R.id.tv_ten);
            viewHolder.textViewCasi = convertView.findViewById(R.id.tv_ca_si);
            viewHolder.textViewThoiGian = convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CaSi caSi = caSiList.get(position);

        viewHolder.textViewTen.setText(String.valueOf(caSi.getmName()));
        viewHolder.textViewThoiGian.setText(String.valueOf(caSi.getmTime()));
        viewHolder.textViewCasi.setText(String.valueOf(caSi.getmSinger()));

        return convertView;
    }

    public class ViewHolder {
        TextView textViewTen, textViewThoiGian, textViewCasi;
    }
}
