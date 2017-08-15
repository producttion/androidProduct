package com.example.teerasaksathu.production;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MyAdapter_ListView extends BaseAdapter {

    private Context context;
    private String[] name;
    private int[] num;

    public MyAdapter_ListView(Context context, String[] name, int[] num) {
        this.context = context;
        this.name = name;
        this.num = num;

    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View ojdview = layoutInflater.inflate(R.layout.datallistview,viewGroup,false);

        TextView tv_num = (TextView) ojdview.findViewById(R.id.tv_num);
        tv_num.setText("");


        TextView tv_cancle = (TextView) ojdview.findViewById(R.id.tv_cancle);
        tv_cancle.setText("");


        TextView tv_date = (TextView) ojdview.findViewById(R.id.tv_date);
        tv_date.setText("");


        return ojdview;
    }










}



