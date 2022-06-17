package com.example.seng405tp.Retrofit;

import com.example.seng405tp.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.seng405tp.util.Constants.*;

public class RetrofitClient {
    private Api myApi;
    private static RetrofitClient instance = null;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }

}
