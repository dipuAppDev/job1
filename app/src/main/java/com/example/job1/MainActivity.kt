package com.example.job1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.job1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productListItem: List<ProductListItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        productListItem = mutableListOf()
        productAdapter = ProductAdapter(productListItem)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        getData()
    }
    private fun getData() {
        RetrofitInstance.apiInterface.getAllData().enqueue(object : Callback<List<ProductListItem>?> {
            override fun onResponse(
                call: Call<List<ProductListItem>?>,
                response: Response<List<ProductListItem>?>
            ) {
                val data = response.body()!!
                productAdapter = ProductAdapter(data)
                binding.recyclerView.adapter = productAdapter
            }
            override fun onFailure(call: Call<List<ProductListItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}