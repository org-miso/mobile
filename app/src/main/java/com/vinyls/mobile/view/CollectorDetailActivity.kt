package com.vinyls.mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinyls.mobile.databinding.ActivityCollectorDetailBinding
import com.vinyls.mobile.dto.AlbumDTO
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Track
import com.vinyls.mobile.util.AlbumUtil
import com.vinyls.mobile.view.adapter.AlbumListAdapter
import com.vinyls.mobile.view.adapter.AlbumListCollectorAdapter
import com.vinyls.mobile.view.adapter.TrackListAdapter
import com.vinyls.mobile.viewmodel.AlbumsViewModel

class CollectorDetailActivity : AppCompatActivity() {

    var list = ArrayList<Album?>()

    private lateinit var binding: ActivityCollectorDetailBinding

    private var albumsViewModel = AlbumsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras

        binding.name.text = b!!.getString("name").toString();
        binding.phone.text = b!!.getString("telephone").toString();
        binding.email.text = b!!.getString("email").toString();

        val itemType = object : TypeToken<List<Album>>() {}.type
        val albums = Gson().fromJson<List<Album>>(b!!.getString("collectorAlbums"), itemType)
        list.addAll(albums)

        var adapter = AlbumListCollectorAdapter(list, this)
        binding.recyclerViewAlbums.adapter = adapter
        binding.recyclerViewAlbums.layoutManager = LinearLayoutManager(this)

        Log.i("HEY", "HEY aqui vamos 1 " + list)

        var listClone = ArrayList<Album?>()
        listClone.addAll(list)
        list.clear()

        Log.i("HEY", "HEY aqui vamos 1.1  " + list)
        Log.i("HEY", "HEY aqui vamos 1.2  " + listClone)

        listClone!!.asSequence().map { a ->
            Log.i("HEY", "HEY aqui vamos 2")
            if (a?.id != null) {
                Log.i("HEY", "HEY aqui vamos 3")
                albumsViewModel.getOneById(a.id!!)
                Log.i("HEY", "HEY aqui vamos 4")
                albumsViewModel.album.observe(this, Observer{
                    Log.i("HEY", "HEY aqui vamos 5 "+  it)
                    list.add(it)
                    adapter.notifyDataSetChanged()
                    binding.loadingPanel.visibility = View.GONE
                })
            }


        }.toList()

        binding.buttonBack.setOnClickListener{
            finish()
        }

    }
}