package com.pradeep.mvpImplementation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pradeep.mvpImplementation.R
import com.pradeep.mvpImplementation.databinding.LayoutProductItemBinding
import com.pradeep.mvpImplementation.models.ProductsItem


class ProductAdapter(productsItem: List<ProductsItem>, private var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var listOfProduct: List<ProductsItem> = productsItem
    lateinit var binding: LayoutProductItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_product_item,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productsItem: ProductsItem = listOfProduct[position]
        holder.bind(productsItem, context)
    }

    override fun getItemCount(): Int {
        return listOfProduct.size
    }

    class ProductViewHolder(private var binding: LayoutProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productsItem: ProductsItem, context: Context) {
            binding.productName.text = productsItem.title
            binding.productDesc.text = productsItem.description
            Glide.with(context).load(productsItem.images[0]).into(binding.productImage)
        }
    }


}
