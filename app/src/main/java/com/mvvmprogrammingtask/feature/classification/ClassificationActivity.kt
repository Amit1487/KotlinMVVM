package com.mvvmprogrammingtask.feature.classification

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mvvmprogrammingtask.R
import com.mvvmprogrammingtask.base.BaseActivity
import com.mvvmprogrammingtask.base.BaseViewModel
import com.mvvmprogrammingtask.util.EndlessScrollListener
import kotlinx.android.synthetic.main.activity_main.*




class ClassificationActivity : BaseActivity() {


    private lateinit var viewModel: ClassificationViewModel

    override fun layoutId(): Int = R.layout.activity_main

    override fun provideBaseModel(): BaseViewModel? = viewModel

    private var  currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ClassificationViewModel::class.java)
        initView()
        observeData()
    }

    lateinit var adapter :ClassificationAdapter
    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = ClassificationAdapter()
        recyclerView.adapter =adapter
        recyclerView.layoutManager = layoutManager
        val scrollListener = object : EndlessScrollListener(layoutManager){
            override fun onLoadMore(currentPage: Int) {
                this@ClassificationActivity.currentPage = currentPage;
                viewModel.loadClassificationData(currentPage)
            }
        }
        recyclerView.addOnScrollListener(scrollListener)
        swiperefresh.setOnRefreshListener {
            currentPage = 1
            viewModel.refresh()
            scrollListener.reset()
        }
        viewModel.refresh()
    }

    private fun observeData() {
        observeError()
        viewModel.observeClassificationData().observe(this, Observer {
            it?.let {data ->
                swiperefresh.isRefreshing = false
                if(currentPage == 1){
                    adapter.replaceAll(data.list)
                }else {
                    adapter.insertMoreItems(data.list)
                }
            }
        })
    }
}