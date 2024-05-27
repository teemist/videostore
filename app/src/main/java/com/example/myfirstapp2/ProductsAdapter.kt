package com.example.myfirstapp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(var products: List<Product>, var context: Context) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.idCatListImage)
        val name: TextView = view.findViewById(R.id.idCatListName)
        val desc: TextView = view.findViewById(R.id.idCatListDesc)
        val price: TextView = view.findViewById(R.id.idCatListPrice)
        val btnDetail: TextView = view.findViewById(R.id.idButtonDetails)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = products[position].name
        holder.desc.text = products[position].description
        holder.price.text = products[position].price.toString() + " руб."


        val imageId = context.resources.getIdentifier(
            products[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.btnDetail.setOnClickListener {
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra("name", products[position].name)
            intent.putExtra("chars", products[position].chars)
            intent.putExtra("price", products[position].price)
            intent.putExtra("image", products[position].image)
            context.startActivity(intent)
        }
    }
}