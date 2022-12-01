package com.vinyls.mobile.view

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.vinyls.mobile.databinding.ActivityAlbumCreateBinding
import com.vinyls.mobile.databinding.ActivityTrackCreateBinding
import com.vinyls.mobile.dto.TrackDTO
import com.vinyls.mobile.model.Track
import com.vinyls.mobile.viewmodel.AlbumsViewModel

class TrackCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackCreateBinding

    private var albumsViewModel = AlbumsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextHours.setRawInputType(Configuration.KEYBOARDHIDDEN_YES)
        binding.editTextMinutes.setRawInputType(Configuration.KEYBOARDHIDDEN_YES)

        val b = intent.extras

        val albumId = b!!.getInt("idAlbum")

        binding.buttonSave.setOnClickListener{
            val track = TrackDTO()
            track.name = binding.editTextName.text.toString()
            track.duration = binding.editTextHours.text.toString() + ":" + binding.editTextMinutes.text.toString()
            albumsViewModel.saveTrack(albumId, track)
            startActivity(Intent(this@TrackCreateActivity, MainActivity::class.java))
        }

    }
}