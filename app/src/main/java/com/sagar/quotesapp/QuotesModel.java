package com.sagar.quotesapp;

import android.graphics.Color;

public class QuotesModel {

    private String quote;
    private String author;


    public QuotesModel(String quote, String author) {
        this.quote = quote;
        this.author = author;

    }

    public QuotesModel() {
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
