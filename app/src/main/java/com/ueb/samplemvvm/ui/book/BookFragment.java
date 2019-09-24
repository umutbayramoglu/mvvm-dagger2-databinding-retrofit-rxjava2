package com.ueb.samplemvvm.ui.book;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ueb.samplemvvm.R;
import com.ueb.samplemvvm.model.Results;
import com.ueb.samplemvvm.ui.ViewModelFactory;
import com.ueb.samplemvvm.ui.adapters.PostListAdapter;
import com.ueb.samplemvvm.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends BaseFragment {

    ViewDataBinding binding;

    private List<Results.Book> notesList = new ArrayList<>();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    ViewModelFactory vmFactory;

    BookListViewModel vm;

    public BookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_post,container,false);
        View view = binding.getRoot();
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        observePosts();
        observeLoadStatus();
        observerErrorStatus();
        setRecyclerView();
    }

    private void observePosts() {
        vm = ViewModelProviders.of(this, vmFactory).get(BookListViewModel.class);
        vm.loadData();
        vm.getBookList().observe(this, new Observer<List<Results.Book>>() {
            private static final String TAG  =  "BookFragment";

            @Override
            public void onChanged(List<Results.Book> notes) {
                if (notes != null) {
                    if (notesList.size() > 0)
                        notesList.clear();
                    notesList.addAll(notes);
                    recyclerView.getAdapter().notifyDataSetChanged();
                    Log.d(TAG,"" + notesList.size());
                }

            }
        });
    }

    @Override
    protected void observerErrorStatus() {
        vm.getErrorStatus().observe(this,
                error -> {
                    if (error != null) {
                      onError(getContext(),error.getMessage());
                        showProgressBar(false);
                    }
                });
    }

    @Override
    protected void observeLoadStatus() {
        vm.getLoadingStatus().observe(
                this,
                isLoading -> showProgressBar(isLoading)
        );
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    private void setRecyclerView() {
        PostListAdapter adapter = new PostListAdapter(notesList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

}
