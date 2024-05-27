package com.example.myfirstapp2
import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Product::class, ProductCartData::class], version = 2)
abstract class MainDB : RoomDatabase() {
    abstract fun getProductDao() : ProductDao
    abstract fun getCartDao() : CartDao
    companion object{
        fun getDB(context: Context) : MainDB{
            return Room.databaseBuilder(
            context.applicationContext,
                MainDB::class.java,
                "text.db"
            ).build()
        }
    }
}