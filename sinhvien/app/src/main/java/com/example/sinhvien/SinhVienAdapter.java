package com.example.sinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<SinhVien> arrSinhVien;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        myContext = context;
        myLayout = layout;
        arrSinhVien = sinhVienList;
    }


    @Override
    public int getCount() {
        return arrSinhVien.size(); // trả ra số dòng listview
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
        LayoutInflater layoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(myLayout, null);
        //mapping
        TextView txtHoten = (TextView) convertView.findViewById(R.id.textViewHoTen);
        TextView tvThuDo = (TextView) convertView.findViewById(R.id.textViewNamSinh);

        // gan gia tri
        txtHoten.setText(arrSinhVien.get(position).getHoTen());
        tvThuDo.setText(String.valueOf(arrSinhVien.get(position).getNamSinh()));
        return convertView;

    }
}
