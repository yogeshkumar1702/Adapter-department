package com.example.adapterdepartment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adapter_department.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Item> items;
    private static int REQUEST_CODE = 6162;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview_department);
        DepartmentListAdapter departmentListAdapter = new DepartmentListAdapter(this,generateItems());
        listView.setAdapter(departmentListAdapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayTheDepartmentDetails(position);
            }
        });


    }

    private ArrayList<Item> generateItems(){
        String DepartmentNames[] = getResources().getStringArray(R.array.department_name);
        String DepartmentHodNames[] = getResources().getStringArray(R.array.department_Hod_list);
        String DepartmentPh[] = getResources().getStringArray(R.array.department_contact_number);
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < DepartmentNames.length; i++) {
            list.add(new Item(DepartmentNames[i],DepartmentHodNames[i],DepartmentPh[i]));
        }
        return list;
    }

    private void DisplayTheDepartmentDetails(int itemPosition){
        Intent i = new Intent(this,infoDisplay.class);
        i.putExtra("POSITION",itemPosition);
        startActivityForResult(i,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            Log.i("Action","Success");
        }

    }
}