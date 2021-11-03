package com.example.lab2_attempt2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    String[] countries = {"delete","edit"};
    ArrayList<Enrollee> enrollees = new ArrayList();
    ArrayList<Enrollee> validEnrollees = new ArrayList();
    ListView enrolleeList;
    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        for (int j = 0;j<enrollees.size();j++){
            if (enrollees.get(j).averageMark() > getAverageUni(enrollees))
            {
                validEnrollees.add(enrollees.get(j));
            }
        }
        enrolleeList = findViewById(R.id.enrolleeList);
        TextView textView = findViewById(R.id.uni_average);
        textView.setText("Average university mark: "+getAverageUniString(enrollees));
        EnrolleeAdapter enrolleeAdapter = new EnrolleeAdapter(this,R.layout.list_enrollee,validEnrollees);
        enrolleeList.setAdapter(enrolleeAdapter);
        Collections.sort(validEnrollees,Enrollee.EnrolleeMarkDescendingComparator);
        registerForContextMenu(enrolleeList);
        /*AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Enrollee selectedEnrollee =(Enrollee)parent.getItemAtPosition(position);

            }
        };
        enrolleeList.setOnItemClickListener(itemClickListener);*/
    }

    int currentposition;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        EnrolleeAdapter info = (EnrolleeAdapter) menuInfo;
        currentposition = info.position;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    @Override
    public boolean  onContextItemSelected(MenuItem item){
        CharSequence message;
        switch (item.getItemId()){
            case R.id.delete:
                message = "Deleting enrollee";
                /*enrolleeList.remove(currentposition);*/
                break;
            case R.id.edit:
                message = "Editing enrollee";
                break;
            default:
                return super.onContextItemSelected(item);
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }
    private void setInitialData(){
        enrollees.add(new Enrollee("Danila","Vladimirovich","Lozko",4,5,9));
        enrollees.add(new Enrollee("Maksim","Olegovich","Semchenko",6,7,9));
        enrollees.add(new Enrollee("Diana","Vladimirovna","Golushko",7,8,10));
        enrollees.add(new Enrollee("Artem","Denisovich","Klimovich",10,10,10));
        enrollees.add(new Enrollee("Artem","Vladimirovich","Lozko",4,9,4));
        enrollees.add(new Enrollee("Valeria","Ruslanovna","Mutalova",7,7,6));
        enrollees.add(new Enrollee("Ivan","Vasilievich","Pupkin",4,4,4));
        enrollees.add(new Enrollee("Eva","Vladimirovna","Lozko",10,9,10));
    }

    private String getAverageUniString(ArrayList<Enrollee> enrollees){
        Double sum = 0.0;
        for (int i = 0;i< enrollees.size();i++){
            sum+= enrollees.get(i).averageMark();
        }

        sum/=enrollees.size();
        String result = String.format("%.1f",sum);
        return result;
    }
    private Double getAverageUni(ArrayList<Enrollee> enrollees){
        Double sum = 0.0;
        for (int i = 0;i< enrollees.size();i++){
            sum+= enrollees.get(i).averageMark();
        }

        sum/=enrollees.size();
        return sum;
    }

}