package com.supremehyo.multitest.api

import com.supremehyo.multitest.model.GithubRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroServiceInstance {
    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String) :List<GithubRepo>
}