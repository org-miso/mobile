package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinyls.mobile.R
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
            binding.loadingPanel.visibility = View.GONE
        })

        binding.bottomNavigationView.menu.findItem(R.id.albums).setChecked(true)

        binding.floatingActionButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, AlbumCreateActivity::class.java))
        }


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.albums -> startActivity(Intent(this@MainActivity, MainActivity::class.java))
                R.id.collections -> startActivity(Intent(this@MainActivity, CollectionActivity::class.java))
                R.id.artists -> startActivity(Intent(this@MainActivity, ArtistActivity::class.java))
                else ->{
                }
            }
            true
        }
    }




}