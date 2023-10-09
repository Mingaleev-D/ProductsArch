package com.example.productsarch.domain.repository

import com.example.productsarch.data.Resource
import com.example.productsarch.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


interface ProductRepository {

   suspend fun fetchAllProducts(): Resource<List<ProductsModel>>

   suspend fun getAllProductsCache(): List<ProductsModel>
   suspend fun insertAllProductsCache(products:List<ProductsModel>)
}