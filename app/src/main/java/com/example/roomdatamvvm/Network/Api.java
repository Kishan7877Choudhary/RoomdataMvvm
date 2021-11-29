package com.example.roomdatamvvm.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static IGoogleApi getClint(){

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .connectTimeout(5, TimeUnit.MINUTES)
                .build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://welcomeinfocom.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        IGoogleApi apiInterface=retrofit.create(IGoogleApi.class);
        return apiInterface;

    }

    public static IGoogleApi getdata(){

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://welcomeinfocom.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IGoogleApi apiInterface=retrofit.create(IGoogleApi.class);
        return apiInterface;

    }

    public static IGoogleApi getcheck(){

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://app.plansinfo.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IGoogleApi apiInterface=retrofit.create(IGoogleApi.class);
        return apiInterface;

    }

}
