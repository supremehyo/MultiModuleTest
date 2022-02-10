package com.supreme.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewDataBinding: T
    abstract val layoutResourceId: Int


    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    private var isSetBackButtonValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //일반적인 setContentView 와는 다르지만 데이터바인딩에서는 이렇게하면 된다.

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)


        initStartView()
        initDataBinding()
        initAfterBinding()
    }
}