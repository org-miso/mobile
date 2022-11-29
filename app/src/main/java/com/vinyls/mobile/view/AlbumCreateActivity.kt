package com.vinyls.mobile.view

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.vinyls.mobile.databinding.ActivityAlbumCreateBinding
import com.vinyls.mobile.databinding.ActivityMainBinding
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.viewmodel.AlbumsViewModel

class AlbumCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumCreateBinding

    private var genres = arrayListOf("Salsa", "Rock", "Classical", "Folk")

    private var recordsLabels = arrayListOf("Elektra", "Sony Music", "EMI", "Discos Fuentes", "Fania Records")

    private var albumsViewModel = AlbumsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var arrayAdapter =
            ArrayAdapter(this, R.layout.simple_spinner_item, genres)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.editTextGenre.adapter = arrayAdapter

        var arrayRecordLabelAdapter =
            ArrayAdapter(this, R.layout.simple_spinner_item, recordsLabels)
        arrayRecordLabelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.editTextRecordLabel.adapter = arrayRecordLabelAdapter

        var genre = "";
        binding.editTextGenre.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                genre = genres[p2];
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        var recordLabel = "";
        binding.editTextRecordLabel.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                recordLabel = recordsLabels[p2];
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        binding.buttonSave.setOnClickListener{
            val albumDTO = AlbumDTO()
            albumDTO.name = binding.edtiTextName.text.toString()
            albumDTO.releaseDate = binding.editTextDate.text.toString()
            albumDTO.cover = binding.editTextCover.text.toString()
            albumDTO.genre = genre
            albumDTO.recordLabel = recordLabel

            albumDTO.description = binding.editTextDescription.text.toString()
            albumsViewModel.saveAlbum(albumDTO)
            startActivity(Intent(this@AlbumCreateActivity, MainActivity::class.java))
        }

    }
}