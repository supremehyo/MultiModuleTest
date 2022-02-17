package com.supremehyo.multitest.api

import com.supremehyo.multitest.model.GithubRepo
import kotlinx.coroutines.flow.Flow

interface GitModel {

    suspend fun getRepos(owner: String) : List<GithubRepo>//테스트

}