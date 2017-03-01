package com.example.haams.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainPageActivity extends AppCompatActivity {

    private Intent gIntent;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        gIntent = getIntent();
        name = gIntent.getStringExtra("name");
        Toast.makeText(getApplicationContext(), name + "님 반갑습니다.", Toast.LENGTH_LONG).show();

    }
}
