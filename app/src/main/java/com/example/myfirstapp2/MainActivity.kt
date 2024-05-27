package com.example.myfirstapp2

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfirstapp2.ui.theme.MyFirstApp2Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkToCatalog: TextView = findViewById(R.id.idCatalogButton)
        linkToCatalog.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }

        val linkToInfo: TextView = findViewById(R.id.idInfoButton)
        linkToInfo.setOnClickListener {
            val intentInfo = Intent(this, ActivityInfo::class.java)
            startActivity(intentInfo)
        }

        val linkToCart: TextView = findViewById(R.id.idCartButton)
        linkToCart.setOnClickListener {
            val intentCart = Intent(this, CartActivity::class.java)
            intentCart.putExtra("key", 1)
            startActivity(intentCart)
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstApp2Theme {
        Greeting("Android")
    }


}