package com.example.productsarch.ui.product_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.productsarch.data.Resource
import com.example.productsarch.databinding.FragmentProductsListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsListFragment : Fragment() {

   private var _binding: FragmentProductsListBinding? = null
   private val binding by lazy { _binding!! }
   private val viewModel by viewModels<ProductsListViewModel>()
   private val productAdapter: ProductListAdapter = ProductListAdapter()

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentProductsListBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      setUiComponents()
      setObservers()



   }

   private fun setObservers() {
      lifecycleScope.launch {
         viewModel.products.observe(viewLifecycleOwner) { result ->
            when (result) {
               is Resource.Error -> {

               }

               Resource.Loading -> {

               }

               is Resource.Success -> {
                  println(result.data)
                  productAdapter.submitList(result.data)
               }
            }
         }
      }
   }

   private fun setUiComponents() {
      binding.rvProducts.apply {
         adapter = productAdapter
      }
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }

}