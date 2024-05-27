package com.example.myfirstapp2

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.InvalidationTracker
import androidx.room.InvalidationTracker.*
import com.example.myfirstapp2.ui.theme.MyFirstApp2Theme
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class CartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)

        val linkToCatalog: TextView = findViewById(R.id.buttonBackMenuFromCart)
        linkToCatalog.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.onDestroy()
        }

        val buyAll: TextView = findViewById(R.id.idBuyButton)
        buyAll.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            val db = MainDB.getDB(this)
            Thread {
                db.getCartDao().deleteAllFromCart()
            }.start()
            val toast = Toast(this)
            toast.setText("Заказ успешно оформлен!")
            toast.show()
            startActivity(intent)
            this.onDestroy()
        }


        val key = intent.getIntExtra("key", 3)
        var db = MainDB.getDB(this)
        val addedProduct = ProductCartData(null, "", 2, 2)

        // добавление
        if (key == 2) {
            val name: String = intent.getStringExtra("name").toString()
            val imageId: Int = intent.getIntExtra("imageId", 1)
            val price = intent.getIntExtra("price", 1)

            addedProduct.name = name
            addedProduct.imageId = imageId
            addedProduct.price = price
            Thread {
                db.getCartDao().insertProductInCart(addedProduct)
            }.start()
        }

        val productCartList: RecyclerView = findViewById(R.id.productCartList)


// Получаем корзину из бд
        db.getCartDao().getAllProducts().asLiveData().observe(this) {
            productCartList.layoutManager = LinearLayoutManager(this)

            // отображение
            val adapterList = arrayListOf<ProductCartData>()
            it.forEach { adapterList.add(it) }
            productCartList.adapter = CartAdapter(adapterList, this)

        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyFirstApp2Theme {
        Greeting3("Android")
    }
}
