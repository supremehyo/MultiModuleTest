package com.supremehyo.multitest.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.viewModelScope
import com.supremehyo.multitest.api.GitModelImple
import com.supremehyo.multitest.model.GithubRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( val client : GitModelImple) : ViewModel() {

    private val _gitHubData =  MutableSharedFlow<List<GithubRepo>>()
    val gitHubData = _gitHubData.asSharedFlow()

    fun getGitHubData(owner : String){
       val job =  viewModelScope.async {
           client.getRepos(owner)
        }

        viewModelScope.launch {
            var data = job.await().asFlow().filter {
                it.name[0] == 'A'
            }
            _gitHubData.emit(data.toList())
        }
    }

}