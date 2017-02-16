package com.example.haams.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton rBtn1, rBtn2, rBtn3, rBtn4, rBtn5, rBtn6;
    private Button btnCall, btnFacebook, btnNext;
    private RadioGroup rGroup;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
//        rBtn1 = (RadioButton)findViewById(R.id.haams);
//        rBtn2 = (RadioButton)findViewById(R.id.wooyoung);
//        rBtn3 = (RadioButton)findViewById(R.id.jongmin);
//        rBtn4 = (RadioButton)findViewById(R.id.sungil);
//        rBtn5 = (RadioButton)findViewById(R.id.chaeyeon);
//        rBtn6 = (RadioButton)findViewById(R.id.nakyung);

        rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnCall = (Button) findViewById(R.id.call);
        btnFacebook = (Button) findViewById(R.id.facebook);
        btnNext = (Button) findViewById(R.id.next);
        btnCall.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        checkRadioButtonClick();

    }

    private void checkRadioButtonClick() {
        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.haams:
                        index = 0;
                        break;
                    case R.id.wooyoung:
                        index = 1;
                        break;
                    case R.id.jongmin:
                        index = 2;
                        break;
                    case R.id.sungil:
                        index = 3;
                        break;
                    case R.id.chaeyeon:
                        index = 4;
                        break;
                    case R.id.nakyung:
                        index = 5;
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.call:
                checkPhoneNumber();
                break;
            case R.id.facebook:
                checkFacebook();
                break;
            case R.id.next:
                checkWhoYouAre();
                break;

        }
    }

    public void checkPhoneNumber() {
        Intent intent = null;
        switch (index) {
            case 0:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "01046182721"));
                startActivity(intent);
                break;
        }
    }

    public void checkFacebook() {
        Intent intent2 = null;
        switch (index) {
            case 0:
                intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://www.facebook.com/seongho.haam"));
                startActivity(intent2);
                break;
        }
    }

    public void checkWhoYouAre() {
        Intent intent3 = null;
        switch (index) {
            case 0:
                intent3 = new Intent(MainActivity.this, SecondActivity.class);
                intent3.putExtra(String.valueOf(index), "Haamseongho");
                startActivity(intent3);
                break;
        }
    }
}
