package com.example.productsarch.domain.usecase

import com.example.productsarch.data.Resource
import com.example.productsarch.domain.model.ProductsModel
import com.example.productsarch.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

   suspend operator fun invoke(): Resource<List<ProductsModel>> {
      return withContext(Dispatchers.IO) {
         val network = repository.fetchAllProducts()

         if (network is Resource.Error) {
            Resource.Error(network.error)
         }
         network as Resource.Success
         repository.insertAllProductsCache(network.data)
         val productList = repository.getAllProductsCache()
         Resource.Success(productList)
      }
   }
}