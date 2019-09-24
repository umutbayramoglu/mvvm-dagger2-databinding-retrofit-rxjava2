package com.ueb.samplemvvm.util;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class Router {

    private Activity activity;

    public Router(Activity activity) {
        this.activity = activity;
    }

    public void  setPostDetailFragment(int containerId,Fragment fragment){

        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);

        ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(null)
                .commit();
    }


    public void setBookListFragment(int containerId, Fragment fragment){

        ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction()
                .replace(containerId,fragment)
                .addToBackStack(null)
                .commit();
    }
}
