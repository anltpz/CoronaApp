package com.example.mvvmexample.bindingadapter

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


object CountriesDataBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String) {
        Picasso.get().load(url).resize(350,150).into(this)

    }

}