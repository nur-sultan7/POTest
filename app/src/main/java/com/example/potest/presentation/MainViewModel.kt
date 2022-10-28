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
import com.example.potest.domain.GetProfileUseCase
import com.example.potest.domain.entity.Profile
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val databaseDao = AppDatabase.getInstance(application).databaseDao()
    private val repositoryImp = RepositoryImp(apiService, databaseDao)
    private val authUserUseCase = AuthUserUseCase(repositoryImp)
    private val getProfileUseCase = GetProfileUseCase(repositoryImp)
    private var _isAuth = MutableLiveData<String?>()
    val isAuth: LiveData<String?>
        get() = _isAuth
    private var _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    fun authUser(email: String, password: String) {
        viewModelScope.launch {
            _isAuth.value = authUserUseCase.invoke(email, password)
        }
    }

    fun getProfile(id: String) {
        viewModelScope.launch {
            _profile.value = getProfileUseCase.invoke(id)
        }
    }
}