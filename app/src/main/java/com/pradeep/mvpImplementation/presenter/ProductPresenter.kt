package com.pradeep.mvpImplementation.presenter

import com.pradeep.mvpImplementation.contract.ProductContract
import com.pradeep.mvpImplementation.models.Products
import com.pradeep.mvpImplementation.retrofit.ProductApi
import com.pradeep.mvpImplementation.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenter(view: ProductContract.View) : ProductContract.Presenter {
    var view: ProductContract.View? = view

    override fun getProducts() {
        view?.showLoading(true)
        val productApiService: ProductApi =
            RetrofitHelper.getInstance().create(ProductApi::class.java)
        val call: Call<Products> = productApiService.getProducts()

        call.enqueue(object : Callback<Products?> {
            override fun onResponse(call: Call<Products?>, response: Response<Products?>) {

                if (response.isSuccessful) {
                    response.body()?.toList()?.let { view?.showContent(it) }
                } else {
                    view?.showErrorView()
                }
                view?.showLoading(false)
            }

            override fun onFailure(call: Call<Products?>, t: Throwable) {
                view?.showLoading(false)
                view?.showErrorView()
            }
        })

    }


}
