package com.example.productsarch.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductsEntiry(
    val category: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

