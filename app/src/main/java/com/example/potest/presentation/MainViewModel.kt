package com.example.potest.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.potest.data.RepositoryImp
import com.example.potest.data.database.AppDatabase
import com.example.potest.data.network.ApiFactory
import com.example.potest.domain.AuthUserUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val databaseDao = AppDatabase.getInstance(application).databaseDao()
    private val repositoryImp = RepositoryImp(apiService, databaseDao)
    private val authUserUseCase = AuthUserUseCase(repositoryImp)
    private var _isAuth = MutableLiveData<Boolean>()
    val isAuth: LiveData<Boolean>
        get() = _isAuth

    fun authUser(email: String, password: String) {
        viewModelScope.launch {
           _isAuth.value = authUserUseCase.invoke(email, password)
        }
    }
}