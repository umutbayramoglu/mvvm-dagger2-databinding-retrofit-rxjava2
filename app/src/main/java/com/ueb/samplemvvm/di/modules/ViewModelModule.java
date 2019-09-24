package com.ueb.samplemvvm.di.modules;

import androidx.lifecycle.ViewModel;

import com.ueb.samplemvvm.di.keys.ViewModelKey;
import com.ueb.samplemvvm.ui.book.BookListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel.class)
    public abstract ViewModel bindPostViewModel(BookListViewModel postViewModel);

}
