package me.mathazak.signupcompose.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mathazak.signupcompose.SignupComposeApp
import me.mathazak.signupcompose.data.UserInfo

class LoginViewModel : ViewModel() {
    private val signupRepository = SignupComposeApp.appModule.signupRepository

    private val _firstName = mutableStateOf("")
    var firstName: State<String> = _firstName

    private var _lastName = mutableStateOf("")
    var lastName: State<String> = _lastName

    private var _birthDate = mutableStateOf("")
    var birthDate: State<String> = _birthDate

    private var _nationalId = mutableStateOf("")
    var nationalId: State<String> = _nationalId

    fun changeFirstName(newValue: String) {
        _firstName.value = newValue
    }

    fun changeLastName(newValue: String) {
        _lastName.value = newValue
    }

    fun changeBirthDate(newValue: String) {
        _birthDate.value = newValue
    }

    fun changeNationalId(newValue: String) {
        _nationalId.value = newValue
    }

    fun submitUser() {
        viewModelScope.launch {
            signupRepository.saveUserInfo(
                UserInfo(firstName.value, lastName.value, birthDate.value, nationalId.value)
            )
        }
    }
}