package com.example.myfirstapp2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class Product(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "imageId")
    val image:String?,
    @ColumnInfo(name = "description")
    val description:String,
    @ColumnInfo(name = "characters")
    val chars:String?,
    @ColumnInfo(name = "price")
    val price:Int) {
}