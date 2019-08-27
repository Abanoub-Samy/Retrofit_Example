package com.example.myapplication;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonApi {

    @GET("posts")
    Call<List<Model>> getData();

    @GET("posts")
    Call<List<Model>> getUserId(
            @Query("userId") int userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts")
    Call<List<Model>> getUserId(@QueryMap Map<String,String> par);
}
