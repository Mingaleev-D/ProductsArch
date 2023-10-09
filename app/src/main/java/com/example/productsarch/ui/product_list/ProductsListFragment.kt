package com.example.productsarch.ui.product_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.productsarch.R
import com.example.productsarch.databinding.FragmentProductsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsListFragment : Fragment() {

   private var _binding: FragmentProductsListBinding? = null
   private val binding by lazy { _binding!! }
   private val viewModel by viewModels<ProductsListViewModel>()

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
      _binding = FragmentProductsListBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }

}