package com.example.myfirstapp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(var products: List<ProductCartData>, var context: Context) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.idCartImage)
        val name: TextView = view.findViewById(R.id.idCartName)
        val btnDelete: TextView = view.findViewById(R.id.idDeleteFromCart)
        val price: TextView = view.findViewById(R.id.idCartPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.products_in_cart, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.name.text = products[position].name
            holder.price.text = products[position].price.toString() + " руб."
            val imageId: Int = products[position].imageId
            holder.image.setImageResource(imageId)
            holder.btnDelete.setOnClickListener {
                val db = MainDB.getDB(context)
                val intent = Intent(context, CartActivity::class.java)
                var id:Int = 0
                Thread {
                    id = db.getCartDao().getLastId()
                    val deletedProduct = ProductCartData(id, products[position].name, products[position].imageId, products[position].price)
                    db.getCartDao().deleteFromCart(deletedProduct)
                }.start()
                context.startActivity(intent)
            }
    }
}