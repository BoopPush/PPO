package com.example.lab2_attempt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
public class EnrolleeAdapter extends ArrayAdapter<Enrollee> {

    private LayoutInflater inflater;
    private int layout;
    private List<Enrollee> enrollees;
    public EnrolleeAdapter(Context context, int resource, List<Enrollee> enrollees){
        super(context,resource,enrollees);
        this.enrollees = enrollees;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position,View convertView, ViewGroup parent){
        View view =inflater.inflate(this.layout,parent,false);
        TextView nameView = view.findViewById(R.id.name);
        TextView marksView = view.findViewById(R.id.marks);
        TextView averageView = view.findViewById(R.id.average_mark);

        Enrollee enrollee = enrollees.get(position);
        nameView.setText(enrollee.getFIO());
        marksView.setText(enrollee.getMarks());
        averageView.setText(enrollee.averageMark());
        return view;
    }
}
