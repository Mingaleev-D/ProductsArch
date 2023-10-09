package com.example.productsarch.ui.product_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productsarch.data.Resource
import com.example.productsarch.domain.model.ProductsModel
import com.example.productsarch.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

   private val _products: MutableLiveData<Resource<List<ProductsModel>>> = MutableLiveData()
   val products: LiveData<Resource<List<ProductsModel>>> = _products

   init {
      getProducts()
   }

   private fun getProducts() {
      viewModelScope.launch {
         _products.postValue(Resource.Loading)
         try {
            val products = getAllProductsUseCase()
            _products.postValue(products)
         } catch (ex: Exception) {
            _products.postValue(Resource.Error(ex))
         }

      }
   }


}