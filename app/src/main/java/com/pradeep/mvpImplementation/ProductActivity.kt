package com.pradeep.mvpImplementation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.pradeep.mvpImplementation.adapter.ProductAdapter
import com.pradeep.mvpImplementation.contract.ProductContract
import com.pradeep.mvpImplementation.databinding.ActivityMainBinding
import com.pradeep.mvpImplementation.models.ProductsItem
import com.pradeep.mvpImplementation.presenter.ProductPresenter


class ProductActivity : AppCompatActivity(), ProductContract.View {
    private var presenter: ProductPresenter? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter = ProductPresenter(this)
        presenter!!.getProducts()
    }

    override fun showContent(listOfProducts: List<ProductsItem>) {
        val adapter = ProductAdapter(listOfProducts, this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        showLoading(false)
    }

    override fun showErrorView() {
        binding.errorViewImage.visibility = View.VISIBLE
        showLoading(false)


    }

    override fun showLoading(show: Boolean) {
        if (show) {
            binding.progressView.visibility = View.VISIBLE
        } else {
            binding.progressView.visibility = View.GONE
        }
    }

}