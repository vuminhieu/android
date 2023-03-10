package com.example.code_mau;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VeTauAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<VeTau> arrayList;

    public VeTauAdapter(Context context, int layout, ArrayList<VeTau> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView tvGadi_gaden = (TextView) view.findViewById(R.id.tvGadi_gaden);
        TextView  tvKhuhoi= (TextView) view.findViewById(R.id.tvKhuhoi);
        TextView tvGiaTien = (TextView) view.findViewById(R.id.tvGiaTien);
        VeTau vetau = arrayList.get(i);
        tvGadi_gaden.setText(vetau.getGaDi()+"->"+vetau.getGaDen());

        if(arrayList.get(i).isKhuHoi()==true){
            tvKhuhoi.setText("Khứ hôi");
        }else{
            tvKhuhoi.setText("Một chiều");
        }
        tvGiaTien.setText(vetau.getDonGia()+"");
        return view;
    }

}
