package com.example.job1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList:List<ProductListItem>)
    :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
        class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val idT : TextView = view.findViewById(R.id.idT)
            val categoryT : TextView = view.findViewById(R.id.categoryT)
            val descriptionT : TextView = view.findViewById(R.id.descriptionT)
            val priceT : TextView = view.findViewById(R.id.priceT)
            val titleT : TextView = view.findViewById(R.id.titleT)
            fun bind(productListItem: ProductListItem){
                idT.text = productListItem.id.toString()
                categoryT.text = productListItem.category.toString()
                descriptionT.text = productListItem.description
                priceT.text = productListItem.price.toString()
                titleT.text = productListItem.title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun getItemCount(): Int {
       return productList.count()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

}