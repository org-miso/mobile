package com.vinyls.mobile.repository.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://back-vinilos-miso.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}