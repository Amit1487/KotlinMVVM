package com.mvvmprogrammingtask.base

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ProgressBar
import android.widget.Toast
import com.mvvmprogrammingtask.model.ViewStatus
import com.mvvmprogrammingtask.exception.Failure
import dagger.android.AndroidInjection
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    private val progressBar : ProgressBar by lazy {
        ProgressBar(this)
    }

    private val observer = Observer<ViewStatus> {
        run {
            it?.let {
                when (it) {
                    is ViewStatus.FAIL -> {
                        progressBar.visibility = View.GONE

                        when (it.failure) {
                            is Failure.NetworkConnection -> showError(it.failure.message, false, it.failure.retry)
                            is Failure.ServerError -> showError(it.failure.message, false, it.failure.retry)
                            is Failure.APIFailure -> showError(it.failure.message, false, it.failure.retry)
                            else -> {
                            }
                        }
                    }
                    is ViewStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        Handler().postDelayed({
                            if (it != ViewStatus.LOADING) {
                                showToast(it.message)
                            }
                        }, 1000)
                    }
                    is ViewStatus.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        if (it != ViewStatus.SUCCESS) {
                            showToast(it.message)
                        } else {

                        }

                    }
                }

            }
        }
    }





    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val handler by lazy {
        Handler()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

    }

    protected fun observeError() {
        provideBaseModel()?.getError()?.observe(this, observer)
    }

    private fun showError(message: String, isFinish: Boolean, retry: () -> Unit) {

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    abstract fun layoutId(): Int

    abstract fun provideBaseModel(): BaseViewModel?



}