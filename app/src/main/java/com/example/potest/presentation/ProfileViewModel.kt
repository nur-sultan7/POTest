package com.example.potest.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.potest.data.RepositoryImp
import com.example.potest.data.database.AppDatabase
import com.example.potest.data.network.ApiFactory
import com.example.potest.domain.GetProfileUseCase
import com.example.potest.domain.entity.Profile
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val apiService = ApiFactory.apiService
    private val databaseDao = AppDatabase.getInstance(application).databaseDao()
    private val repositoryImp = RepositoryImp(application, apiService, databaseDao)
    private val getProfileUseCase = GetProfileUseCase(repositoryImp)

    private var _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    fun getProfile() {
        viewModelScope.launch {
            _profile.value = getProfileUseCase.invoke()
        }
    }
}