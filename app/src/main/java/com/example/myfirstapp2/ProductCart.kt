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

class ProductCart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_in_cart)

        val name : TextView = findViewById(R.id.idCartName)
        val image : ImageView = findViewById(R.id.idCartImage)
        val price : TextView = findViewById(R.id.idCartPrice)

        name.text = intent.getStringExtra("name")
        val imageId:Int = intent.getIntExtra("imageId", 1)

        image.setImageResource(imageId)
        price.text = intent.getStringExtra("price")

    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MyFirstApp2Theme {
        Greeting4("Android")
    }
}