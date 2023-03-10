package com.example.listview_20_10.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview_20_10.R;
import com.example.listview_20_10.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    private Context mContext;
    private int mResource;
    private List<SinhVien> sinhVienList;


    public SinhVienAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.sinhVienList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_sinh_vien, parent,false);

            //anh xa
            viewHolder.textView_ten = convertView.findViewById(R.id.txt_ten);
            viewHolder.textView_dia_chi = convertView.findViewById(R.id.txt_dia_chi);
            viewHolder.textView_sdt = convertView.findViewById(R.id.txt_sdt);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SinhVien sinhVien = sinhVienList.get(position);
        // gan gia tri
        viewHolder.textView_ten.setText(String.valueOf(sinhVien.getmTen()));
        viewHolder.textView_dia_chi.setText(String.valueOf(sinhVien.getmDiachi()));
        viewHolder.textView_sdt.setText(String.valueOf(sinhVien.getmSDT()));


        return convertView;
    }

    public class ViewHolder {
        private TextView textView_ten;
        private TextView textView_dia_chi;
        private TextView textView_sdt;
    }


}
