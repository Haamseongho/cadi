package com.example.haams.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private Intent gIntent;
    private int data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        gIntent = getIntent();
        data = gIntent.getIntExtra("main",-1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1001:
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("KEY");
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
