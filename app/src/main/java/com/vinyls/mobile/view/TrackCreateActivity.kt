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
import com.vinyls.mobile.model.Track

class TrackCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextHours.setRawInputType(Configuration.KEYBOARDHIDDEN_YES)
        binding.editTextMinutes.setRawInputType(Configuration.KEYBOARDHIDDEN_YES)

        val b = intent.extras

        val albumId = b!!.getInt("idAlbum")
        Log.i("TAG DEV", albumId.toString())

        binding.buttonSave.setOnClickListener{
            val track = Track()
            track.name = binding.editTextName.toString()
            track.duration = binding.editTextHours.toString() + ":" + binding.editTextMinutes.toString()
            Log.i("INFO DEVX", binding.editTextName.toString()  + "  " + track.duration.toString())
        }

    }
}