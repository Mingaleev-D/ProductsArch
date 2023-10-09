package com.example.productsarch.ui.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.productsarch.R
import com.example.productsarch.databinding.ProductsItemBinding
import com.example.productsarch.domain.model.ProductsModel

/**
 * @author : Mingaleev D
 * @data : 09.10.2023
 */


class ProductListAdapter :
    ListAdapter<ProductsModel, ProductListAdapter.ProductViewHolder>(Companion) {

   companion object : DiffUtil.ItemCallback<ProductsModel>() {
      override fun areItemsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
         return oldItem::class == newItem::class
      }

      override fun areContentsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
         return oldItem == newItem
      }
   }

   inner class ProductViewHolder(val binding: ProductsItemBinding) :
       RecyclerView.ViewHolder(binding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
      return ProductViewHolder(
          ProductsItemBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
          )
      )
   }

   override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
      val products = currentList[position]

      holder.binding.tvName.text = products.title
      holder.binding.tvPrice.text = products.price.toString()
      holder.binding.tvBrand.text = products.category

      holder.binding.ivImage.loadImage(products.image)
   }
}

fun ImageView.loadImage(path: String?) {
   Glide.with(this.context).load(path)
       .apply(centerCropTransform().error(R.drawable.ic_launcher_background)).into(this)
}