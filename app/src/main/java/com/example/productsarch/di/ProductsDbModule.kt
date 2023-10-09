package com.example.productsarch.di

import android.content.Context
import androidx.room.Room
import com.example.productsarch.data.local.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsDbModule {

   @Provides
   @Singleton
   fun provideDatabase(@ApplicationContext context: Context) =
       Room.databaseBuilder(context, ProductsDatabase::class.java, "DATABASE_NAME").build()

   @Provides
   @Singleton
   fun provideDao(database: ProductsDatabase) = database.productsDao()
}