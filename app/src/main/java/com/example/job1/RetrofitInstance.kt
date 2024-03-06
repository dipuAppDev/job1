package com.example.job1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //https://api.escuelajs.co/api/v1/products
    var baseUrl = "https://api.escuelajs.co/api/v1/"
    private val retrofit by lazy {
       Retrofit.Builder().baseUrl(baseUrl).
       addConverterFactory(GsonConverterFactory.create())
           .build()
    }
    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}