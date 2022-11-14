package com.vinyls.mobile.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityAlbumDetailBinding
import com.vinyls.mobile.model.Track

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

        binding.buttonSong.setOnClickListener{
            val intent = Intent(this@AlbumDetailActivity, TracksActivity::class.java)
            intent.putExtra("tracksAlbum", b!!.getString("tracksAlbum"))
            intent.putExtra("idAlbum", b!!.getInt("idAlbum"))
            startActivity(intent)
        }

    }

}