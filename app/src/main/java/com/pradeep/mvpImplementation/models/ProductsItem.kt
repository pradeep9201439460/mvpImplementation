package com.pradeep.mvpImplementation.models

data class ProductsItem(
    val category: Category,
    val categoryId: Int,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String
)