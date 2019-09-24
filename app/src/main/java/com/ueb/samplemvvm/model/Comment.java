package com.ueb.samplemvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment extends BaseObservable {

    @SerializedName("postId")
    @Expose
    private String postId;


    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("body")
    @Expose
    private String body;

    public Comment(String postId, String id, String name, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.body = body;
    }

    @Bindable
    public String getPostId() {
        return postId;
    }


    public String getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getBody() {
        return body;
    }
}
