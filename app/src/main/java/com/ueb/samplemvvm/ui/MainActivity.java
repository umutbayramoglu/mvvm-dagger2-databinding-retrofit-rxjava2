package com.ueb.samplemvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import com.ueb.samplemvvm.R;
import com.ueb.samplemvvm.databinding.ActivityMainBinding;
import com.ueb.samplemvvm.ui.book.BookFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setFragment(R.id.container, new BookFragment());
    }


    public void setFragment(int layoutId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(layoutId, fragment)
                .commit();
    }

}
