package com.example.potest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potest.domain.AuthUserUseCase
import com.example.potest.domain.LoadProfileUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authUserUseCase: AuthUserUseCase,
    private val loadProfileUseCase: LoadProfileUseCase
) : ViewModel() {
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