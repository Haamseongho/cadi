package com.example.haams.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEnroll;
    private EditText editName,editAge;
    private Intent sIntent;
    private static final int RequestCode = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnEnroll = (Button)findViewById(R.id.btn_enroll);
        editName = (EditText)findViewById(R.id.editName);
        editAge = (EditText)findViewById(R.id.editAge);

        btnEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIntent = new Intent(MainActivity.this,FirstPageActivity.class);
                sIntent.putExtra("name",editName.getText().toString());
                sIntent.putExtra("age",editAge.getText().toString());
                startActivityForResult(sIntent,1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1001:
                if(resultCode == RESULT_OK){
                    Toast.makeText(MainActivity.this,data.getStringExtra("send"),Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
