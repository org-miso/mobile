package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinyls.mobile.databinding.ActivityAlbumDetailBinding
import com.vinyls.mobile.databinding.ActivityTracksBinding
import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.model.Track
import com.vinyls.mobile.view.adapter.MusicianListAdapter
import com.vinyls.mobile.view.adapter.TrackListAdapter

class TracksActivity : AppCompatActivity() {

    var list = ArrayList<Track?>()

    private lateinit var binding: ActivityTracksBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTracksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter = TrackListAdapter(list, this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val b = intent.extras

        binding.buttonAddTrack.setOnClickListener{
            val intent = Intent(this@TracksActivity, TrackCreateActivity::class.java)
            intent.putExtra("idAlbum", b!!.getInt("idAlbum"))
            startActivity(intent)
        }


        val itemType = object : TypeToken<List<Track>>() {}.type
        val tracks = Gson().fromJson<List<Track>>(b!!.getString("tracksAlbum"), itemType)
        val albumID = b!!.getInt("idAlbum")

        list.addAll(tracks)


    }


}