package com.example.haams.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = (TextView) findViewById(R.id.whoYouAre);
        changeName();
    }

    private void changeName() {
        name.setText(getIntent().getExtras().getString("0"));
    }
}
