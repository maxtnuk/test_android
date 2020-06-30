package com.example.apptest.network;

import com.example.apptest.model.Book;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @GET("/api/v1/products")
    Call<ResponseBook> getBookList();

    @GET("/api/v1/products/{id}")
    Call<ResponseBook> getBook(@Path("id") String id);

    @POST("/api/v1/products")
    Call<ResponseBook> addBook(@Body Book book);

    @DELETE("/api/v1/products/{id}")
    Call<ResponseBook> deleteBook(@Path("id") String id);

}
