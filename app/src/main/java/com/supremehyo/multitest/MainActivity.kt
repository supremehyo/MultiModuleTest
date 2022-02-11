package com.supremehyo.multitest

import android.util.Log
import androidx.activity.viewModels
import com.supreme.base.BaseActivity
import com.supremehyo.multitest.databinding.ActivityMainBinding
import com.supremehyo.multitest.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    //빨간색 나왔던 이유  fragment:fragment-ktx  activity:activity-ktx 의존성이 없어서
    private val viewModel: MainViewModel by viewModels()

    override fun initStartView() {
        viewModel.getGitHubData("supremehyo")
    }

    override fun initDataBinding() {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            viewModel.gitHubData.collect {
                    it.forEach {
                        Log.v("gitData" , it.name)
                    }
            }
        }
    }

    override fun initAfterBinding() {

    }


}