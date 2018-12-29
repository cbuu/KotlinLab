package com.iori.kotlinlab.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetCore {
//    private static final String BASE_URL = "https://api.github.com/";
//
//    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//    private static Retrofit.Builder builder = new Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create());
//
//    private static Retrofit retrofit = builder.client(httpClient.build()).build();
//
//    public static <S> S createService(Class<S> serviceClass) {
//        return retrofit.create(serviceClass);
//    }

    private val BASE_URL = "http://45.77.123.205:8080"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

    fun <S> createService(c:Class<S>):S {
        return retrofit.create(c)
    }

}