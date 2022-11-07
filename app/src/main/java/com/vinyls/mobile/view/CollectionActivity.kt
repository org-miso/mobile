package com.vinyls.mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinyls.mobile.databinding.ActivityMainBinding

class CollectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}