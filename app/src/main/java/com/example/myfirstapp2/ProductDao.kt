package com.example.myfirstapp2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product:Product)
    @Query("SELECT * FROM products")
    fun getAllProducts() : Flow<List<Product>>
}