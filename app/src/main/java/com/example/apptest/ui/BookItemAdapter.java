package com.example.apptest.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.databinding.ActivitySubBinding;
import com.example.apptest.databinding.ItemBookBinding;
import com.example.apptest.model.Book;

import java.util.ArrayList;

public class BookItemAdapter extends RecyclerView.Adapter<BookItemAdapter.BookHolder> {

    private ArrayList<Book> books;
    private ItemClickEvent clickEvent=null;

    public BookItemAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setClickEvent(ItemClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }


    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        ItemBookBinding binding=ItemBookBinding.inflate(inflater,parent,false);
        return new BookHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.bind(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder{

        private ItemBookBinding binding;
        private Book book;

        public BookHolder(ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            binding.bookItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickEvent.onClickItem(book.getId());
                }
            });
        }

        public void bind(Book book){
            this.book=book;
            binding.title.setText(book.getName());
            binding.price.setText(String.valueOf(book.getPrice()));
        }
    }
}
