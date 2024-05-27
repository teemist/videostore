package com.example.myfirstapp2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp2.ui.theme.MyFirstApp2Theme

class ProductDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val linkToCatalog: TextView = findViewById(R.id.idButtonBackFromDetails)
        linkToCatalog.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        val name : TextView = findViewById(R.id.idNameDetails)
        val image : ImageView = findViewById(R.id.idImgDetails)
        val chars : TextView = findViewById(R.id.idCharsDetails)
        val price : TextView = findViewById(R.id.idPriceDetails)

        name.text = intent.getStringExtra("name")
        val imageId = resources.getIdentifier(
            intent.getStringExtra("image"),
            "drawable",
            packageName
        )
        image.setImageResource(imageId)
        chars.text = intent.getStringExtra("chars")
        val priceInt: Int = intent.getIntExtra("price", 1)
        price.text = intent.getIntExtra("price", 1).toString() + " руб."

        val addToCart: TextView = findViewById(R.id.idButtonAddToCart)
        addToCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)

            intent.putExtra("name", name.text)
            intent.putExtra("price", priceInt)
            intent.putExtra("imageId", imageId)
            intent.putExtra("key", 2)
            this.onDestroy()
            startActivity(intent)

        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MyFirstApp2Theme {
        Greeting4("Android")
    }
}