package com.pradeep.mvpImplementation.contract

import com.pradeep.mvpImplementation.models.ProductsItem

class ProductContract {

    interface View {
        fun showContent(listOfProducts: List<ProductsItem>)
        fun showErrorView()
        fun showLoading(show: Boolean)

    }

    interface Presenter {
        fun getProducts()
    }
}