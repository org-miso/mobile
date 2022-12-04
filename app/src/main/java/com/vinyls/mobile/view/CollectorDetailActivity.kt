package com.vinyls.mobile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinyls.mobile.databinding.ActivityCollectorDetailBinding

class CollectorDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectorDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras


        binding.name.text = b!!.getString("name").toString();
        binding.phone.text = b!!.getString("telephone").toString();
        binding.email.text = b!!.getString("email").toString();

        binding.buttonBack.setOnClickListener{
            finish()
        }

    }
}