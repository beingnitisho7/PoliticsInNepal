package com.example.ramesh.politicsinnepal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramesh on 10/10/17.
 */

public class HomeLayout_Adapter extends ArrayAdapter<String> {


    ImageView logo;
    TextView menu;

    private final Activity context;
    private final String[] menuItem;
    private final Integer[] menuId;

    private static LayoutInflater inflater = null;

    public HomeLayout_Adapter(Activity context, String[] menuItem, Integer[] menuId) {
        super(context, R.layout.activity_menu_layout, menuItem);

        this.context=context;
        this.menuItem=menuItem;
        this.menuId=menuId;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.activity_menu_layout, null,true);

        logo=v.findViewById(R.id.logo);
        menu=v.findViewById(R.id.menu);

        menu.setText(menuItem[position]);
        logo.setImageResource(menuId[position]);
        return v;


    }

}
