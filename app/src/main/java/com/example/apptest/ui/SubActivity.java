package com.example.apptest.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.apptest.databinding.ActivitySubBinding;
import com.example.apptest.model.Book;
import com.example.apptest.network.Api;
import com.example.apptest.network.Client;
import com.example.apptest.network.ResponseBook;

import android.content.Intent;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubActivity extends AppCompatActivity {

    private ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String id= intent.getStringExtra("id");

        Api api=Client.retrofit.create(Api.class);

        api.getBook(id).enqueue(new Callback<ResponseBook>() {
            @Override
            public void onResponse(Call<ResponseBook> call, Response<ResponseBook> response) {
                if (response.isSuccessful()&&response.body()!=null){
                    Book book = response.body().getBook();
                    binding.nameContent.setText(book.getName());
                    binding.descriptionContent.setText(book.getDescription());
                    binding.priceContent.setText(String.valueOf(book.getPrice()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBook> call, Throwable t) {

            }
        });

    }
}
