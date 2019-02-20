package com.example.galax.simplemovieapp.services.rest;


import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.App;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClien {
    public static RestAPI createApi() {
        Retrofit.Builder builder = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(App.getInstance().getApplicationContext().getString(R.string.base_url));

        return builder.build().create(RestAPI.class);
    }

}
