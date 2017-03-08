package com.example.haams.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegister;
    private EditText editName, editAge, editPart;
    private RadioButton rBtnMale, rBtnFemale;

    private Intent intent;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);
        editPart = (EditText) findViewById(R.id.editPart);

        rBtnMale = (RadioButton) findViewById(R.id.rBtn_male);
        rBtnFemale = (RadioButton) findViewById(R.id.rBtn_female);

        btnRegister = (Button) findViewById(R.id.btnSignIn);


        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                checkInfoWell();
                break;

        }

    }

    private void checkInfoWell() {
        if (editName.getText().toString().equals("") || editAge.getText().toString().equals("") || editPart.getText().toString().equals("")
                || !rBtnMale.isChecked() && !rBtnFemale.isChecked()) {

            final LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            final View itemView = inflater.inflate(R.layout.wrong_info, null, false);
            final AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            // 객체 ( 이미지뷰 객체 선언해서 작업 )


            Glide.with(MainActivity.this)
                    .load("http://cfs7.tistory.com/upload_control/download.blog?fhandle=YmxvZzgyMzM1QGZzNy50aXN0b3J5LmNvbTovYXR0YWNoLzAvMDYwMDAwMDAwMDAwLmpwZw%3D%3D")
                    .fitCenter()
                    .into((ImageView)itemView.findViewById(R.id.wrongImage));



            dlg.setTitle("입력할 정보를 다 입력해주세요");
            dlg.setView(itemView);


            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"다시 입력합니다.",Toast.LENGTH_LONG).show();
                }
            });
            dlg.show();

        } else {
            intent = new Intent(MainActivity.this, MainPageActivity.class);
            intent.putExtra("name", editName.getText().toString());
            startActivity(intent);
        }
    }
}
