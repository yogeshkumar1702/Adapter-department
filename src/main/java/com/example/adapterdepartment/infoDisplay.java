package com.example.adapterdepartment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adapter_department.R;

import java.util.ArrayList;

public class infoDisplay extends AppCompatActivity {

    int item_number;
    ArrayList<Item> items;

    TextView departmentName;
    TextView departmentHodName;
    TextView departmentcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);
        items = generateItems();

        item_number = getIntent().getIntExtra("POSITION",-1);

        departmentName = findViewById(R.id.textView_department_content);
        departmentHodName = findViewById(R.id.textView_department_Hod_content);
        departmentcontact = findViewById(R.id.textView_department_contact_content);

        Item CurrentItem = items.get(item_number);

        departmentName.setText(CurrentItem.getItemName());
        departmentHodName.setText(CurrentItem.getItemDescription());
        departmentcontact.setText(CurrentItem.getitemPhonenumber());


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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent data = new Intent();
        setResult(RESULT_OK, data);
        finish();
    }
}