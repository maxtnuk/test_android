package com.example.apptest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.apptest.databinding.ActivityMainBinding;
import com.example.apptest.model.Book;
import com.example.apptest.network.Api;
import com.example.apptest.network.Client;
import com.example.apptest.network.ResponseBook;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MutableLiveData<ArrayList<Book>> bookList = new MutableLiveData<>();
    private BookItemAdapter bookItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bookItemAdapter = new BookItemAdapter(new ArrayList<Book>());
        bookItemAdapter.setClickEvent(new ItemClickEvent() {
            @Override
            public void onClickItem(String id) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        binding.bookList.setAdapter(bookItemAdapter);

        bookList.observe(this, new Observer<ArrayList<Book>>() {
            @Override
            public void onChanged(ArrayList<Book> books) {
                bookItemAdapter.setBooks(books);
                bookItemAdapter.notifyDataSetChanged();
            }
        });


        Api api = Client.retrofit.create(Api.class);

        api.getBookList().enqueue(new Callback<ResponseBook>() {
            @Override
            public void onResponse(Call<ResponseBook> call, Response<ResponseBook> response) {
                if (response.isSuccessful() && response.body() != null) {
                    bookList.postValue(new ArrayList<>(response.body().getBooks()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBook> call, Throwable t) {
                Log.e("network", t.getMessage());
            }
        });

    }
}
