package com.ueb.samplemvvm.di.modules;
import com.ueb.samplemvvm.ui.book.BookFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {PostModule.class})
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = {ViewModelModule.class})
    abstract BookFragment contributeNoteFragment();

}
