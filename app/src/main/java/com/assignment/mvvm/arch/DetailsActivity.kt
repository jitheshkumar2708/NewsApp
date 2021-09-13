package com.assignment.mvvm.arch

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assignment.mvvm.R
import com.assignment.mvvm.data.NewsEntity
import com.assignment.mvvm.databinding.DetailsActivityBinding


class DetailsActivity : AppCompatActivity() {

    var source : String ? =null
    var author: String? = null
    var title: String? = null
    var description : String ? =null
    var image: String? = null
    var date : String? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: DetailsActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.details_activity)
            title = getIntent().getStringExtra("title")
            image = getIntent().getStringExtra("imageUrl")
            source= getIntent().getStringExtra("source")
            description= getIntent().getStringExtra("description")
            date= getIntent().getStringExtra("date")
            var newsEntity= NewsEntity(1,"",source,"",title,description,"",image,date,"")
            binding.item =newsEntity



}