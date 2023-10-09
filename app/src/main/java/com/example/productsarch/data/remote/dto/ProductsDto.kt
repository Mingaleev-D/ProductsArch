package com.example.productsarch.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ProductsDto(
    @SerializedName("category")
    val category: String,
//    @SerializedName("description")
//    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
//    @SerializedName("rating")
//    val rating: Rating,
    @SerializedName("title")
    val title: String
)