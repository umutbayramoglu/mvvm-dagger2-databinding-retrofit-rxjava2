package com.ueb.samplemvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results extends BaseObservable {

    @SerializedName("books")
    @Expose
    private List<Book> results;

    @Bindable
    public List<Book> getResults() {
        return results;
    }


    public class Book extends BaseObservable {

        @SerializedName("title")
        @Expose
        private String name;


        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("book_image")
        @Expose
        private String image;

        @SerializedName("author")
        @Expose
        private String author;

        @SerializedName("rank")
        @Expose
        private String rank;

        @SerializedName("price")
        @Expose
        private String price;

        @SerializedName("publisher")
        @Expose
        private String publisher;


        public String getPrice() {
            return price;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getRank() {
            return rank;
        }

        @Bindable
        public String getAuthor() {
            return author;
        }

        @Bindable
        public String getImage() {
            return image;
        }

        @Bindable
        public String getName() {
            return name;
        }

        @Bindable
        public String getDescription() {
            return description;
        }
    }
}


