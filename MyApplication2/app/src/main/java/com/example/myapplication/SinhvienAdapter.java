package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SinhvienAdapter extends ArrayAdapter<Sinhvien> {
    public SinhvienAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public SinhvienAdapter(@NonNull Context context, int resource, @NonNull List<Sinhvien> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v==null){
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_list, null);
        }
        Sinhvien p = getItem(position);
        if (p!=null){
            TextView tv1 = (TextView) v.findViewById(R.id.textViewHoten);
            TextView tv2 = (TextView) v.findViewById(R.id.textViewNamsinh);
            tv1.setText(p.Hoten);
            tv2.setText(String.valueOf(p.Namsinh));
        }

        return v;
    }
}

