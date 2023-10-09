package com.example.productsarch.data.remote

import com.example.productsarch.data.remote.dto.ProductsDto
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


interface ApiService {

   companion object{
      const val BASE_URL = "https://fakestoreapi.com/"
   }

   @GET("products")
   suspend fun fetchProducts():List<ProductsDto>
}