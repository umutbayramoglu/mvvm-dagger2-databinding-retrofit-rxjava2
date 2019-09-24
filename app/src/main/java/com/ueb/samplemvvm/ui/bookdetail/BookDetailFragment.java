package com.ueb.samplemvvm.ui.bookdetail;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ueb.samplemvvm.R;
import com.ueb.samplemvvm.databinding.FragmentBookDetailBinding;
import com.ueb.samplemvvm.model.Results;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailFragment extends Fragment {

    private Results.Book book;
    FragmentBookDetailBinding binding;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    public BookDetailFragment(Results.Book book) {
       this.book = book;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book_detail,container,false);
        binding.setBook(book);
        return binding.getRoot();
    }



}
