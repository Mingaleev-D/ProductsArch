package com.example.productsarch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


@Database(entities = [ProductsEntiry::class], version = 1)
abstract class ProductsDatabase : RoomDatabase() {
   abstract fun productsDao():ProductsDao
}