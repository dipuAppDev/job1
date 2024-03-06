package com.example.job1

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //https://api.escuelajs.co/api/v1/products
    @GET("products")
    fun getAllData() : Call<List<ProductListItem>>
}