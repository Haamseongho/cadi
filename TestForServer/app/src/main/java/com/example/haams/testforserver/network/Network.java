package com.example.haams.testforserver.network;

import com.example.haams.testforserver.network.admin.AdminProxy;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haams on 2017-05-12.
 */

public class Network {
    private static Network network;
    private Retrofit retrofit;
    private AdminProxy adminProxy;

    public static Network getNetworkInstance(){
        if(network == null){
            network = new Network();
        }
        return network;
    }

    public Network() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder().baseUrl("http://52.79.83.51:2721/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build();

        adminProxy = new AdminProxy(retrofit);
    }

    public AdminProxy getAdminProxy() {
        return adminProxy;
    }
}
