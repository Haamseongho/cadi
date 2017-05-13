package com.example.haams.testforserver.network.admin;

import com.example.haams.testforserver.data.Admin;
import com.example.haams.testforserver.network.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by haams on 2017-05-12.
 */

public class AdminProxy {
    private Service service;

    public AdminProxy(Retrofit retrofit) {
        service = retrofit.create(Service.class);
    }

    public void saveDataToServer(String name, double age, String password, Callback<Admin> callback) {
        Call<Admin> call = service.saveDataFromServer(name, age, password);
        call.enqueue(callback);
    }

    public void getUserInfoFromServer(String name, Callback<Admin> callback) {
        Call<Admin> call = service.getUserInfoFromServer(name);
        call.enqueue(callback);
    }
}
