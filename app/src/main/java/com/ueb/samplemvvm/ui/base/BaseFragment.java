package com.ueb.samplemvvm.ui.base;

import android.content.Context;
import android.widget.Toast;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {


    protected void observerErrorStatus(){}
    protected void observeLoadStatus(){}

    protected void onError(Context context,String message){
        Toast.makeText(context, "Error: " + message, Toast.LENGTH_SHORT).show();
    }

}
