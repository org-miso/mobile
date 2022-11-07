package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityAlbumDetailBinding
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
            adapter.setOnItemClickListener(object:AlbumListAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {

                    Toast.makeText(this@MainActivity,
                        "Clicked", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@MainActivity, AlbumDetailActivity::class.java).apply {
                        putExtra("album", it[position]?.id)
                    }
                    startActivity(intent)
                }

            })
            adapter.notifyDataSetChanged()

        })



        binding.bottomNavigationView.setOnItemSelectedListener {
            Log.i("INFO", it.itemId.toString())

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