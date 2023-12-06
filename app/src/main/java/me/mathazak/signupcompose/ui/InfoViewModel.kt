package me.mathazak.signupcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.mathazak.signupcompose.SignupComposeApp
import me.mathazak.signupcompose.data.UserInfo

class InfoViewModel : ViewModel() {
    private val signupRepository = SignupComposeApp.appModule.signupRepository

    private val _userInfo: MutableStateFlow<UserInfo> = MutableStateFlow(
        UserInfo("", "", "", "")
    )
    val userInfo: StateFlow<UserInfo> = _userInfo.asStateFlow()

    init {
        viewModelScope.launch {
            signupRepository.getUserInfo().collect { value ->
                _userInfo.value = value
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            signupRepository.clearUserInfo()
        }
    }
}