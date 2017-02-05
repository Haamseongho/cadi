package com.example.haams.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIntro;
    private EditText name, age, school, part;
    private String intro;
    private Button btnIntro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        /*
        아이디 찾아오기!!
         */
        btnIntro = (Button) findViewById(R.id.btn_intro);
        name = (EditText) findViewById(R.id.edName);
        age = (EditText) findViewById(R.id.edAge);
        school = (EditText) findViewById(R.id.edSchool);
        part = (EditText) findViewById(R.id.edPart);
        btnIntro2 = (Button) findViewById(R.id.btn_intro2);

        // 1번째방법 --> 익명클래스로 바로 구현해버리기
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, name.getText().toString() + "/" + age.getText().toString() + "/" + school.getText().toString() + "/" + part.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


        // 2번째방법 --> View.OnClickListener를 구현하는 클래스를 만들어주기!
        btnIntro.setOnClickListener(btnClick);
        btnIntro2.setOnClickListener(btnClick);

        // 3번째방법 --> implements를 액티비티에서 바로 하기!!
        btnIntro.setOnClickListener(this);
        btnIntro2.setOnClickListener(MainActivity.this);


    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_intro:
                    Toast.makeText(MainActivity.this, name.getText().toString() + "/" + age.getText().toString() + "/" + school.getText().toString() + "/" + part.getText().toString(), Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_intro2:
                    //
                    break;
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intro:
                //
                break;
            case R.id.btn_intro2:
                //
                break;

        }
    }
}
