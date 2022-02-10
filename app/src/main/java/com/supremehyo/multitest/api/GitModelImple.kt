package com.supremehyo.multitest.api

import com.supremehyo.multitest.model.GithubRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitModelImple  @Inject constructor (private val serviceInstance: RetroServiceInstance) : GitModel{


    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return serviceInstance.getRepos(owner)
    }

}