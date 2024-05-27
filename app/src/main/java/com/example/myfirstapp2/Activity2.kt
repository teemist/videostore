package com.example.myfirstapp2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val linkToCatalog: TextView = findViewById(R.id.buttonBackMenu)
        linkToCatalog.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val productList: RecyclerView = findViewById(R.id.productsList)
        val products = arrayListOf<Product>()

        val nvidia = Product(
            1, "MSI NVIDIA Geforce 1060", "big1060",
            "Среднебюджетная производительная\n" +
                    "видеокарта. 6GB видеопамяти GDDR5.",
            "Техпроцесс: 16нм\n" +
                    "Видеопамять: 6GB\n" +
                    "Тип памяти: GDDR5\n" +
                    "Разрядность шины: 192бит\n" +
                    "Тип охлаждения: воздушное\n" +
                    "Толщина: 39мм", 11990
        )

        val amd = Product(
            2, "MSI AMD Radeon RX 6650 XT", "big6650",
            "Современная игровая видеокарта.\n" +
                    "8GB видеопамяти GDDR6. TDP 65W.",
            "Видеопамять: 8GB\n" +
                    "Тип памяти: GDDR6\n" +
                    "Разрядность шины: 128бит\n" +
                    "Тип охлаждения: воздушное\n" +
                    "Толщина: 47мм", 23990
        )

        val intel = Product(
            3, "AsRock INTEL Arc A770", "bigarca770",
            "Современная игровая видеокарта.\n" +
                    "8GB видеопамяти GDDR6. TDP 65W.",
            "Видеопамять: 16GB\n" +
                    "Тип памяти: GDDR6\n" +
                    "Разрядность шины: 256бит\n" +
                    "Тип охлаждения: воздушное\n" +
                    "Толщина: 56мм", 37990

        )

        val gtx750 = Product(
            4, "NVIDIA GTX750Ti", "big750ti",
            "Тихая устаревшая видеокарта.\n" +
                    "2GB видеопамяти GDDR5.",
            "Видеопамять: 2GB\n" +
                    "Тип памяти: GDDR5\n" +
                    "Разрядность шины: 128бит\n" +
                    "Тип охлаждения: воздушное\n" +
                    "Толщина: 56мм", 4990
        )

        val rtx4060 = Product(
            5, "NVIDIA RTX4060Ti", "big4060",
            "Дорогая мощная видеокарта.\n" +
                    "8GB видеопамяти GDDR6.",
            "Видеопамять: 8GB\n" +
                    "Тип памяти: GDDR5\n" +
                    "Разрядность шины: 128бит\n" +
                    "Тип охлаждения: воздушное\n" +
                    "Толщина: 56мм", 120990
        )

        products.add(nvidia)
        products.add(amd)
        products.add(intel)
        products.add(gtx750)
        products.add(rtx4060)

        productList.layoutManager = LinearLayoutManager(this)
        productList.adapter = ProductsAdapter(products, this)
    }
}