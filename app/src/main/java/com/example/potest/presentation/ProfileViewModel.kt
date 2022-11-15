package com.example.potest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potest.domain.GetProfileUseCase
import com.example.potest.domain.entity.Profile
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {

    private var _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile>
        get() = _profile

    fun getProfile() {
        viewModelScope.launch {
            _profile.value = getProfileUseCase.invoke()
        }
    }
}