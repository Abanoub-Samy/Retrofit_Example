package com.example.myapplication;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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


    ////////////////////////////////////////////////////////////



    @POST("posts")
    Call<Model> createPosts (@Body Model model);

    @FormUrlEncoded
    @POST("posts")
    Call<Model> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Model> createPost(@FieldMap Map<String, String> fields);
}
