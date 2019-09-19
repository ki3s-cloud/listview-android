package com.example.oderfoods;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodsAdapter extends BaseAdapter {
    Context context;
    int layout;
    int sum = 0;
    ArrayList<Foods> arrayList;
    ArrayList<Integer> arrayListsend;

    public ArrayList<Integer> getArrayListsend() {
        return arrayListsend;
    }

    public void setArrayListsend(ArrayList<Integer> arrayListsend) {
        this.arrayListsend = arrayListsend;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public FoodsAdapter(Context context, int layout, ArrayList<Foods> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.list_item,viewGroup,false);

        TextView cost = view.findViewById(R.id.costFoods);
        CheckBox checkFoods = view.findViewById(R.id.checkFoods);

        final Foods foods = arrayList.get(i);
        cost.setText(String.valueOf(foods.getCost()));
        checkFoods.setChecked(foods.isCheck());

        arrayListsend = new ArrayList<>();
        checkFoods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    sum += foods.getCost();
                    arrayListsend.add(foods.getCost());
                }
                else {
                    sum-= foods.getCost();
                Log.d("sum", String.valueOf(sum));
                }
            }
        });
        return view;
    }
}
