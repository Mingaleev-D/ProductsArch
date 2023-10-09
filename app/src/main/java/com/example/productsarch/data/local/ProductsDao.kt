package com.example.productsarch.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */

@Dao
interface ProductsDao {

   @Query("SELECT * FROM ProductsEntiry")
   fun getAllProducts(): List<ProductsEntiry>

   @Insert(onConflict = REPLACE)
   fun insertAllProducts(productList: List<ProductsEntiry>)
}