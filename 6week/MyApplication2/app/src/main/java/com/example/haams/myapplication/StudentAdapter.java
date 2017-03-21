package com.example.haams.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by haams on 2017-03-11.
 */

public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> stuList;
    private Context context;
    private TextView name;
    private TextView number;
    private Button btnIntro;

    public StudentAdapter(ArrayList<Student> stuList, Context context) {
        this.stuList = stuList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stuList.size();
    }

    @Override
    public Object getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.stu_items, parent, false);

        name = (TextView) convertView.findViewById(R.id.stuName);
        number = (TextView) convertView.findViewById(R.id.stuNum);


        btnIntro = (Button) convertView.findViewById(R.id.btnIntro);

        fillViews(name, number, btnIntro, position);

        return convertView;
    }

    private void fillViews(TextView name, TextView number, Button btnIntro, int position) {
        name.setText(stuList.get(position).getName());
        number.setText(stuList.get(position).getNumber());


        btnIntro.setText("자기 소개");
        btnIntro.setOnClickListener(new IntroBtnClick(position));

    }

    private class IntroBtnClick implements View.OnClickListener {

        int position;

        public IntroBtnClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            for(int i=-1;i<position;i++){
                Toast.makeText(context,stuList.get(position).getName()
                        + "/" +
                        stuList.get(position).getNumber()
                        , Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
