package com.example.apptest.network;

import com.example.apptest.model.Book;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseBook {
    @SerializedName("success")
    Boolean success;
    @SerializedName("book")
    Book book;
    @SerializedName("booklist")
    ArrayList<Book> books;
    @SerializedName("msg")
    String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
