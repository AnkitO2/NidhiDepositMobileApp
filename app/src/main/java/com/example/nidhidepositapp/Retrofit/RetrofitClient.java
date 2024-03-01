package com.example.nidhidepositapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static ApiServices getClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://depositmobile.allsoft.online/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices apiServices = retrofit.create(ApiServices.class);
        return apiServices;
    }
}
