package com.ueb.samplemvvm.data.remote.repo;

import com.ueb.samplemvvm.data.remote.APIService;
import com.ueb.samplemvvm.model.ResultsResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class BookRepo {

    private final APIService api;

    @Inject
    public BookRepo(APIService api) {
        this.api = api;
    }

    public Single<ResultsResponse> fetchBooks(){
        return api.getBooks();
    }


  }
