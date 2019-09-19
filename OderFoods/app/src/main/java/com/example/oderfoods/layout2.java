package com.example.oderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class layout2 extends AppCompatActivity {

    ListView listView;
    TextView textView;
    Button back;
    ArrayList< Integer> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        listView = findViewById(R.id.listview);
        textView = findViewById(R.id.tongtien);
        int total;

        Intent i = getIntent();
        // lấy dữ liệu là arraylist các listitem được check
        arrayList = (ArrayList<Integer>)getIntent().getSerializableExtra("list");

        //
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView.setAdapter(arrayAdapter);

        total = i.getIntExtra("total",0);
        textView.setText(String.valueOf(total));


    }
}
