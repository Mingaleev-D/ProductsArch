package com.example.productsarch.data

sealed class Resource <out R> {
   data class Success<out T>(val data: T): Resource<T>()
   data class Error(val error: Exception): Resource<Nothing>()
   object Loading: Resource<Nothing>()
}

fun<T> Resource<T>.mapToUiState(): UiState<T> {
   return when (this) {
      is Resource.Success -> UiState.Success(data = data)
      is Resource.Error -> UiState.Error(error = error)
      else -> throw IllegalStateException("Resource type not supported")
   }
}

sealed class UiState <out R> {
   data class Success<out T>(val data: T): UiState<T>()
   data class Error(val error: Exception): UiState<Nothing>()
   object Loading: UiState<Nothing>()
}

