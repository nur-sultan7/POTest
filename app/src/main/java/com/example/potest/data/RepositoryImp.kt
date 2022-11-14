package com.example.potest.data

import com.example.potest.data.database.DatabaseDao
import com.example.potest.data.network.ApiService
import com.example.potest.domain.Repository
import com.example.potest.domain.entity.Profile
import retrofit2.await
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val databaseDao: DatabaseDao,
    private val mapper: Mapper,
    private val sessionManager: SessionManager
) : Repository {


    override suspend fun authUser(email: String, password: String): String? {
        return try {
            val call = apiService.authUser(mapper.getJsonBody(email, password))
            val token = call.await()
            sessionManager.saveAuthToken(token.getBearerToken())
            null
        } catch (e: Exception) {
            e.message.toString()
        }
    }

    override suspend fun getProfile(): Profile {
        val id = sessionManager.fetchUserId()
        return mapper.mapProfileModelToEntity(databaseDao.getProfile(id))
    }

    override suspend fun loadProfile(): String? {
        return try {
            val token = sessionManager.fetchAuthToken()
            val call = apiService.getProfile(token)
            val profileModel = mapper.mapProfileDtoTOModel(call.await())
            databaseDao.insertProfile(profileModel)
            sessionManager.saveUserId(profileModel.id)
            null
        } catch (e: Exception) {
            e.message.toString()
        }
    }

}