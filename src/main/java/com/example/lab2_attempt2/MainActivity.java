package com.example.lab2_attempt2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Enrollee> enrollees = new ArrayList();
    ListView enrolleeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        enrolleeList = findViewById(R.id.enrolleeList);
        EnrolleeAdapter enrolleeAdapter = new EnrolleeAdapter(this,R.layout.list_enrollee,enrollees);
        enrolleeList.setAdapter(enrolleeAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Enrollee selectedEnrollee =(Enrollee)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран " + selectedEnrollee.getFIO(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        enrolleeList.setOnItemClickListener(itemClickListener);
    }

    private void setInitialData(){
        enrollees.add(new Enrollee("Danila","Vladimirovich","Lozko"/*,4,5,9*/));
        enrollees.add(new Enrollee("Maksim","Olegovich","Semchenko"/*,6,7,9*/));
        enrollees.add(new Enrollee("Diana","Vladimirovna","Golushko"/*,7,8,10*/));
    }

}