package com.example.a05_10_22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        //mapping
        TextView tv_name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView tv_address = (TextView) convertView.findViewById(R.id.txt_address);
        TextView tv_age = (TextView) convertView.findViewById(R.id.txt_age);

        // gan gia tri
        tv_name.setText(sinhVienList.get(position).getName());
        tv_address.setText(sinhVienList.get(position).getAddress());
        tv_age.setText(String.valueOf(sinhVienList.get(position).getAge()));
        return convertView;
    }
}
