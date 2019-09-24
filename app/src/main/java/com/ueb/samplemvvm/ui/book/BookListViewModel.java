package com.ueb.samplemvvm.ui.book;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ueb.samplemvvm.data.remote.repo.BookRepo;
import com.ueb.samplemvvm.model.ResultsResponse;
import com.ueb.samplemvvm.model.Results;
import com.ueb.samplemvvm.ui.base.BaseViewModel;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class BookListViewModel extends BaseViewModel {

    private static final String TAG = "BookListViewModel";
    private final BookRepo bookRepo;
    private CompositeDisposable disposable;
    private MutableLiveData<List<Results.Book>> bookList = new MutableLiveData<>();

    @Inject
    public BookListViewModel(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        disposable = new CompositeDisposable();
    }

    public LiveData<List<Results.Book>> getBookList() {
        return bookList;
    }


    public void loadData() {

        disposable.add(bookRepo.fetchBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribeWith(new DisposableSingleObserver<ResultsResponse>() {

                    @Override
                    public void onSuccess(ResultsResponse resultsResponse) {
                       bookList.setValue(resultsResponse.getResults().getResults());

                    }

                    @Override
                    public void onError(Throwable e) {
                       e.printStackTrace();
                       onError.setValue(e);
                    }
                }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
