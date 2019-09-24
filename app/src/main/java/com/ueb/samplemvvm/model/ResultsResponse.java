package com.ueb.samplemvvm.model;

import com.google.gson.annotations.SerializedName;

public class ResultsResponse {

    @SerializedName("results")
    public Results results;



    public Results getResults() {
        return results;
    }


}
