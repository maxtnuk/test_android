package com.example.apptest.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static String baseurl="http://132.145.88.114:8000";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Client.baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
