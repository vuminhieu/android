package com.example.demo_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BaiHocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BaiHoc> baiHocList;

    public BaiHocAdapter(Context context, int layout, List<BaiHoc> baiHocList) {
        this.context = context;
        this.layout = layout;
        this.baiHocList = baiHocList;
    }

    @Override
    public int getCount() {
        return baiHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView tvTen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
            convertView = inflater.inflate(layout, null);
            holder.tvTen = (TextView) convertView.findViewById(R.id.tv_ten);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        BaiHoc baiHoc = baiHocList.get(position);
        holder.tvTen.setText(baiHoc.getTenbai());

        return convertView;

    }
}
