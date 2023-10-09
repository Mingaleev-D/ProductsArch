package com.example.productsarch.data.mapper

import com.example.productsarch.data.local.ProductsEntiry
import com.example.productsarch.data.remote.dto.ProductsDto
import com.example.productsarch.domain.model.ProductsModel


/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


fun ProductsDto.maToDomain(): ProductsModel {
   return ProductsModel(
       category = category,
       id = id,
       image = image,
       price = price,
       title = title
   )
}

fun List<ProductsDto>.mapToDomainList(): List<ProductsModel> {
   return this.map { it.maToDomain() }
}

fun ProductsEntiry.mapToEntity(): ProductsModel {
   return ProductsModel(
       category = category,
       id = id,
       image = image,
       price = price,
       title = title
   )
}

fun List<ProductsEntiry>.mapToEntityList(): List<ProductsModel> {
   return this.map { it.mapToEntity() }
}

fun ProductsModel.mapToDomainInEntity(): ProductsEntiry {
   return ProductsEntiry(
       category = category,
       id = id,
       image = image,
       price = price,
       title = title
   )
}

fun List<ProductsModel>.mapToDomainInEntityList(): List<ProductsEntiry> {
   return this.map { it.mapToDomainInEntity() }
}