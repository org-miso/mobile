package com.vinyls.mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinyls.mobile.databinding.ActivityMainBinding
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.view.adapter.AlbumListAdapter
import com.vinyls.mobile.viewmodel.AlbumsViewModel

class MainActivity : AppCompatActivity() {

    var albums = ArrayList<Album?>()

    private lateinit var binding: ActivityMainBinding

    private var albumsViewModel = AlbumsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var adapter = AlbumListAdapter(albums, this)
        binding.recyclerViewAlbums.adapter = adapter
        binding.recyclerViewAlbums.layoutManager = LinearLayoutManager(this)

        albumsViewModel.getAllAlbums()
        albumsViewModel.albums.observe(this, Observer{
            albums.addAll(it)
            adapter.notifyDataSetChanged()
        })



//        binding.getAlbumsButton.setOnClickListener{

//            Toast.makeText(
//                this,
//                "Obteniendo Albumnes",
//                Toast.LENGTH_LONG
//            ).show()}

    }
}