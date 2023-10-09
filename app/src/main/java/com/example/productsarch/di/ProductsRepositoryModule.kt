package com.example.productsarch.di

import com.example.productsarch.data.repository.ProductsRepositoryImpl
import com.example.productsarch.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsRepositoryModule {

   @Binds
   abstract fun bindProductsRepository(productsRepository: ProductsRepositoryImpl): ProductRepository
}