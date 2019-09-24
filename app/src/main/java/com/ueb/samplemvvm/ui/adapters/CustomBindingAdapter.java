package com.ueb.samplemvvm.ui.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView view, String url) {
        if (url == null) {
            view.setImageDrawable(null);
        } else {
            Picasso.get().load(url).into(view);
        }
    }
}
