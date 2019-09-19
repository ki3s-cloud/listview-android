package com.example.oderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    FoodsAdapter foodsFoodsAdapter;
    ArrayList<Foods> arrayList;
    ArrayList<Integer> arrayListsend;
    TextView txtsum;
    Button oder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.list);
        arrayList = new ArrayList<>();
        arrayListsend = new ArrayList<>();

        txtsum = findViewById(R.id.total);
        oder = findViewById(R.id.oder);

        foodsFoodsAdapter = new FoodsAdapter(this,R.layout.list_item,arrayList);
        lv.setAdapter(foodsFoodsAdapter);
        // tạo dữ liệu sẵn
        arrayList.add(new Foods(15000,false));
        arrayList.add(new Foods(25000,false));
        arrayList.add(new Foods(35000,false));
        arrayList.add(new Foods(45000,false));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+ arrayList.get(i).getCost(), Toast.LENGTH_SHORT).show();
            }
        });
        // sự kiện nhấn nút để chuyển dữ liệu
        oder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // duyệt arraylist để tìm hàng được check
                for(int i = arrayList.size()-1; i >=0;i--){
                    Foods foods = arrayList.get(i);
                    if(foods.isCheck()) {
                        arrayListsend.add(foods.getCost());
                    }
            }

                Intent i = new Intent(MainActivity.this,layout2.class);
                i.putExtra("list",foodsFoodsAdapter.getArrayListsend());
                i.putExtra("total",foodsFoodsAdapter.getSum());
                startActivity(i);
                foodsFoodsAdapter.setSum(0);
                // cập nhật lại ds như ban đầu
            foodsFoodsAdapter.notifyDataSetChanged();
            }

        });
    }
}
