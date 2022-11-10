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
import com.example.potest.domain.LoadProfileUseCase
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val databaseDao = AppDatabase.getInstance(application).databaseDao()
    private val repositoryImp = RepositoryImp(application, apiService, databaseDao)
    private val authUserUseCase = AuthUserUseCase(repositoryImp)
    private val loadProfileUseCase = LoadProfileUseCase(repositoryImp)
    private var _isAuthorized = MutableLiveData<String?>()
    val isAuthorized: LiveData<String?>
        get() = _isAuthorized
    private var _isProfileLoaded = MutableLiveData<String?>()
    val isProfileLoaded: LiveData<String?>
        get() = _isProfileLoaded

    fun authUser(email: String, password: String) {
        viewModelScope.launch {
            _isAuthorized.value = authUserUseCase.invoke(email, password)
        }
    }

    fun loadProfile() {
        viewModelScope.launch {
            _isProfileLoaded.value = loadProfileUseCase.invoke()
        }
    }
}