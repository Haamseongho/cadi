package com.example.haams.testforserver;

import android.renderscript.Script;
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

public class SecondActivity extends AppCompatActivity {

    private EditText findUserName;
    private Network network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
    }

    private void initViews() {
        findUserName = (EditText) findViewById(R.id.findUser);
        findViewById(R.id.btnCheckInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                network = Network.getNetworkInstance();
                network.getAdminProxy().getUserInfoFromServer(findUserName.getText().toString(), new Callback<Admin>() {
                    @Override
                    public void onResponse(Call<Admin> call, Response<Admin> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(SecondActivity.this, response.body().getName() + " / "
                                    + response.body().getAge() + " / " + response.body().getPassword() + " 입니다. ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Admin> call, Throwable t) {
                        Log.e("Second", t.toString());
                    }
                });
            }
        });
    }
}
