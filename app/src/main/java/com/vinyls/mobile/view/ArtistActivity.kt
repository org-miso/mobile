package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityArtistBinding
import com.vinyls.mobile.databinding.ActivityMainBinding
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.view.adapter.AlbumListAdapter
import com.vinyls.mobile.view.adapter.MusicianListAdapter
import com.vinyls.mobile.viewmodel.AlbumsViewModel
import com.vinyls.mobile.viewmodel.MusicianViewModel

class ArtistActivity : AppCompatActivity() {

    var list = ArrayList<Musician?>()

    private lateinit var binding: ActivityArtistBinding

    private var musicianViewModel = MusicianViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter = MusicianListAdapter(list, this)
        binding.recyclerViewAlbums.adapter = adapter
        binding.recyclerViewAlbums.layoutManager = LinearLayoutManager(this)

        musicianViewModel.getAllAlbums()
        musicianViewModel.albums.observe(this, Observer{
            list.addAll(it)
            adapter.notifyDataSetChanged()
            binding.loadingPanel.visibility = View.GONE
        })

        binding.bottomNavigationView.menu.findItem(R.id.artists).setChecked(true)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.albums -> startActivity(Intent(this@ArtistActivity, MainActivity::class.java))
                R.id.collections -> startActivity(Intent(this@ArtistActivity, CollectionActivity::class.java))
                R.id.artists -> startActivity(Intent(this@ArtistActivity, ArtistActivity::class.java))
                else ->{
                }
            }
            true
        }


    }
}