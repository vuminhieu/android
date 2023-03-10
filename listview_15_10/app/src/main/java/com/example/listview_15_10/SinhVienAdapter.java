package com.example.listview_15_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    Context mycontext;
    Integer mylayout;
    List<SinhVien> arrSinhVien;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        mycontext = context;
        mylayout = layout;
        arrSinhVien = sinhVienList;
    }

    @Override
    public int getCount() {
        return arrSinhVien.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(mylayout, null);
        // mapping
        TextView ten = (TextView) convertView.findViewById(R.id.textView_Content);
        // gan gia tri
        ten.setText(arrSinhVien.get(position).getName());
        return convertView;
    }
}
