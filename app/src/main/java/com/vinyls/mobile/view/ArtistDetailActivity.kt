package com.vinyls.mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.vinyls.mobile.databinding.ActivityArtistDetailBinding

class ArtistDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras

        val urlImage = b!!.getString("image").toString();
        var imageView = binding.image as ImageView
        Picasso.get().load(urlImage).into(imageView)


        binding.title.text = b!!.getString("title").toString();
        binding.description.text = b!!.getString("description").toString();

        binding.buttonBack.setOnClickListener{
            finish()
        }

    }
}