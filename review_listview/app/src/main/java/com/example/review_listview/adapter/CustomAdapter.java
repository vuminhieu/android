package com.example.review_listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.review_listview.R;
import com.example.review_listview.model.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends ArrayAdapter<SinhVien> implements Filterable{
    private Context mContext;
    private int mResource;
    List<SinhVien> sinhVienList;
    List<SinhVien> mListUsersOld;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.sinhVienList = objects;
        this.mListUsersOld = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        // kiem xem listview co gia tri hay chua
        if (convertView == null) {
//            anh xa qua convertView thong qua LayoutInflater
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_sinh_vien, parent,false);
            // anh xa
            viewHolder.textViewTen = convertView.findViewById(R.id.edt_ten);
            viewHolder.textViewDiaChi = convertView.findViewById(R.id.tv_dia_chi);
            viewHolder.textViewTuoi = convertView.findViewById(R.id.tv_tuoi);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SinhVien sinhVien = sinhVienList.get(position);
        // gan gia tri
        viewHolder.textViewTen.setText(String.valueOf(sinhVien.getmTen()));
        viewHolder.textViewDiaChi.setText(String.valueOf(sinhVien.getmDiaChi()));
        viewHolder.textViewTuoi.setText(String.valueOf(sinhVien.getmTuoi()));

        return convertView;
    }

    public class ViewHolder {
        TextView textViewTen, textViewDiaChi, textViewTuoi;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()) {
                    sinhVienList = mListUsersOld;
                }
                else {
                    List<SinhVien> list = new ArrayList<>();
                    for (SinhVien user : mListUsersOld) {
                        if (user.getmTen().toLowerCase().contains(strSearch.toLowerCase())) {
                            list.add(user);
                        }
                    }
                    sinhVienList = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = sinhVienList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                sinhVienList = (List<SinhVien>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
