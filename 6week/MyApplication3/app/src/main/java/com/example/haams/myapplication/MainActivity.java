package com.example.haams.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2,btn3;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        frame= (FrameLayout)findViewById(R.id.frame);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Fragment1()).commit();
                break;
            case R.id.btn2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Fragment2()).commit();
                break;
            case R.id.btn3:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Fragment3()).commit();
                break;
        }
    }
}
