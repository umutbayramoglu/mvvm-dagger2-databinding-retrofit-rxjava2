package com.ueb.samplemvvm.ui.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {

    protected final MutableLiveData<Boolean> loadingStatus = new  MutableLiveData<>();
    protected final MutableLiveData<Throwable> onError = new  MutableLiveData<>();

    public MutableLiveData<Boolean> getLoadingStatus() {
        return loadingStatus;
    }

    public MutableLiveData<Throwable> getErrorStatus() {
        return onError;
    }
}


