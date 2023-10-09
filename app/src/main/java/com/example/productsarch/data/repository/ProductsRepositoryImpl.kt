package com.example.productsarch.data.repository

import com.example.productsarch.data.Resource
import com.example.productsarch.data.local.ProductsDao
import com.example.productsarch.data.mapper.mapToDomainInEntityList
import com.example.productsarch.data.mapper.mapToDomainList
import com.example.productsarch.data.mapper.mapToEntityList
import com.example.productsarch.data.remote.ApiService
import com.example.productsarch.domain.model.ProductsModel
import com.example.productsarch.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: ProductsDao
) : ProductRepository {

   override suspend fun fetchAllProducts(): Resource<List<ProductsModel>> {
      return try {
         val productslist = apiService.fetchProducts().mapToDomainList()
         Resource.Success(productslist)
      } catch (ex: Exception) {
         Resource.Error(ex)
      }
   }

   override suspend fun getAllProductsCache(): List<ProductsModel> {
        return dao.getAllProducts().mapToEntityList()

   }

   override suspend fun insertAllProductsCache(products: List<ProductsModel>) {
         dao.insertAllProducts(products.mapToDomainInEntityList())

   }
}