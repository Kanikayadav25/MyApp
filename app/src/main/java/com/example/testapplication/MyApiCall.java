package com.example.testapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    @GET("v2/list?page=34")
    Call<List<DataModel>> getData();
}
