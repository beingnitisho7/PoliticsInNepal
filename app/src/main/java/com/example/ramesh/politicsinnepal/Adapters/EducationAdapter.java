package com.example.ramesh.politicsinnepal.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ramesh.politicsinnepal.R;

/**
 * Created by ramesh on 10/13/17.
 */

public class EducationAdapter extends ArrayAdapter<String> {

    TextView education;

    private final Activity context;
    private final String[] educationItem;


    public EducationAdapter(Activity context, String[] educationItem) {
        super(context, R.layout.education_layout, educationItem);

        this.context=context;
        this.educationItem = educationItem;



    }



    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.education_layout, null,true);

        education=v.findViewById(R.id.eduListlayout);

        education.setText(educationItem[position]);
        return v;


    }
}
