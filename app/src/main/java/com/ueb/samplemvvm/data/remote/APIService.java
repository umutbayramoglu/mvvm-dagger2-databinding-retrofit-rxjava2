package com.ueb.samplemvvm.data.remote;

import com.ueb.samplemvvm.model.ResultsResponse;
import com.ueb.samplemvvm.util.Constants;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface APIService {

    @GET(Constants.BOOKS)
    Single<ResultsResponse> getBooks();
}
