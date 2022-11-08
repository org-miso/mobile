package com.vinyls.mobile.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityAlbumDetailBinding

class AlbumDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAlbumDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras

        val urlImage = b!!.getString("coverAlbum").toString();
        var imageView = binding.imageAlbum as ImageView
        Picasso.get().load(urlImage).into(imageView)

        binding.titleAlbumView.text = b!!.getString("nameAlbum").toString();
        binding.genderAlbumView.text = b!!.getString("genreAlbum").toString();
        binding.recordLabel.text = b!!.getString("recordLabelAlbum").toString();
        binding.date.text = b!!.getString("releaseDateAlbum").toString();
        binding.description.text = b!!.getString("descriptionAlbum").toString();

    }

}