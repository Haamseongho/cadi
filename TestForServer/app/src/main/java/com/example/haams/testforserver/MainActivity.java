package com.example.haams.testforserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haams.testforserver.data.Admin;
import com.example.haams.testforserver.network.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtAge, edtPassword;
    private Network network;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        edtName = (EditText) findViewById(R.id.edtId);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        intent = new Intent(MainActivity.this,SecondActivity.class);

        findViewById(R.id.btnEnroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToServer();
            }
        });
    }

    private void saveDataToServer() {
        network = Network.getNetworkInstance();
        network.getAdminProxy().saveDataToServer(edtName.getText().toString(),
                Double.parseDouble(edtAge.getText().toString()),
                edtPassword.getText().toString(),
                new Callback<Admin>() {
                    @Override
                    public void onResponse(Call<Admin> call, Response<Admin> response) {
                        if (response.isSuccessful()) {
                            Log.d("Main",response.body()+"111");
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Admin> call, Throwable t) {
                        Log.e("Main", t.toString());
                    }
                });
    }
}
