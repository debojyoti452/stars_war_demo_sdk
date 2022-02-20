package com.example.mvvm_app.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity(), BaseInterface {

    open fun vmObserver() {}

    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        vmObserver()
    }

    override fun showLog(msg: Any) {
        Timber.d(msg.toString())
    }
}
