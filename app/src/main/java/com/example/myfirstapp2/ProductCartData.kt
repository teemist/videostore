package com.example.myfirstapp2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "cart")
data class ProductCartData (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "image")
    var imageId: Int,
    @ColumnInfo(name = "price")
    var price: Int
)