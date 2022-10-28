package com.example.potest.data

import com.example.potest.data.database.DatabaseDao
import com.example.potest.data.network.ApiService
import com.example.potest.domain.Repository
import retrofit2.await

class RepositoryImp(
    private val apiService: ApiService,
    private val databaseDao: DatabaseDao
) : Repository {

    private val mapper = Mapper()
    override suspend fun authUser(email: String, password: String): Boolean {
        try {
            val call = apiService.authUser(mapper.getJsonBody(email, password))
            val token = call.await()
            loadProfile(token.getBearerToken())
        } catch (e: Exception) {
            return false
        }
        return true
    }

    private suspend fun loadProfile(token: String) {
        val call = apiService.getProfile(token)
        val profileModel = mapper.mapProfileDtoTOModel(call.await())
        databaseDao.insertProfile(profileModel)
    }
}