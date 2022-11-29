package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityCollectionBinding
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.view.adapter.CollectorListAdapter
import com.vinyls.mobile.viewmodel.CollectorsViewModel

class CollectionActivity : AppCompatActivity() {

    var list = ArrayList<Collector?>()

    private lateinit var binding: ActivityCollectionBinding

    private var collectorsViewModel = CollectorsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter = CollectorListAdapter(list, this)
        binding.recyclerViewCollectors.adapter = adapter
        binding.recyclerViewCollectors.layoutManager = LinearLayoutManager(this)

        collectorsViewModel.getAllCollectors()
        collectorsViewModel.collectors.observe(this, Observer{
            list.addAll(it)
            adapter.notifyDataSetChanged()
            binding.loadingPanel.visibility = View.GONE
        })

        binding.bottomNavigationView.menu.findItem(R.id.collections).setChecked(true)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.albums -> startActivity(Intent(this@CollectionActivity, MainActivity::class.java))
                R.id.collections -> startActivity(Intent(this@CollectionActivity, CollectionActivity::class.java))
                R.id.artists -> startActivity(Intent(this@CollectionActivity, ArtistActivity::class.java))
                else ->{
                }
            }
            true
        }



    }
}