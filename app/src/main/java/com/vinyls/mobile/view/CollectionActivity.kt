package com.vinyls.mobile.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinyls.mobile.R
import com.vinyls.mobile.databinding.ActivityCollectionBinding
import com.vinyls.mobile.databinding.ActivityMainBinding

class CollectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

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