package com.example.haams.testforserver.network;

import com.example.haams.testforserver.data.Admin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by haams on 2017-05-12.
 */

public interface Service {
    @FormUrlEncoded
    @POST("/admin")
    public Call<Admin> saveDataFromServer(
            @Field("name") String name,
            @Field("age") double age,
            @Field("password") String password
    );

    @GET("/findUser")
    public Call<Admin> getUserInfoFromServer(
            @Query("name") String name
    );
}
