package com.pradeep.mvpImplementation.retrofit

import com.pradeep.mvpImplementation.models.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    fun getProducts() : Call<Products>


}