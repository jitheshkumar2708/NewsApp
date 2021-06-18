package com.assignment.mvvm.ext

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.assignment.mvvm.R
import com.bumptech.glide.Glide

@BindingAdapter("visible")
fun setVisibility(view: View, isVisible: Boolean?) {
    view.visibility = if (isVisible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImageUrl(view: ImageView, url: String?) {
    if (url != null) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(view)
    } else {
        Glide.with(view.context)
            .load(R.drawable.ic_launcher_foreground)
            .into(view)
    }
}

@BindingAdapter("date")
fun displayDate(view: TextView, date: String?) {
    view.text = date?.getDisplayableDate()
}