package com.ueb.samplemvvm.di.modules;

import com.ueb.samplemvvm.data.remote.APIService;
import com.ueb.samplemvvm.data.remote.repo.BookRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    @Singleton
    @Provides
    static BookRepo provideNoteRepo(APIService noteAPI){
        return new BookRepo(noteAPI);
    }
}
