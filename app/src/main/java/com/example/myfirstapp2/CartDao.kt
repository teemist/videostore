package com.example.myfirstapp2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("DELETE FROM cart")
    fun deleteAllFromCart()
    @Query("SELECT MAX(id) FROM cart")
    fun getLastId(): Int
    @Delete
    fun deleteFromCart(productCartData: ProductCartData)
    @Update
    fun updateProductCount(productCartData: ProductCartData)
    @Insert
    fun insertProductInCart(productCartData: ProductCartData)
    @Query("SELECT * FROM cart")
    fun getAllProducts() : Flow<List<ProductCartData>>
    @Query("SELECT * FROM cart")
    fun getListProducts() : List<ProductCartData>
}