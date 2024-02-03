package com.tematihonov.effectivemobiletest.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.effectivemobiletest.data.local.UserEntity
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val roomRepository: RoomRepository
): ViewModel() {

    var userLogined by mutableStateOf(false)
    var userLoginedChecking by mutableStateOf(true)

    var buttonActivity by mutableStateOf(false)

    var firstName by mutableStateOf("")
    var firstNameValidation by mutableStateOf(true)
    var secondName  by mutableStateOf("")
    var secondNameValidation by mutableStateOf(true)
    var phoneNumber by mutableStateOf("")
    var phoneNumberValidation by mutableStateOf(true)

    init {
        testUserLogin()
    }

    fun testUserLogin() {
        viewModelScope.launch {
            if (roomRepository.checkUserLogin()) {
                userLogined = false
            } else userLogined = true
            userLoginedChecking = false
        }
    }

    fun userLogin(): Boolean {
        when (firstNameValidation == secondNameValidation || firstNameValidation == phoneNumberValidation || firstNameValidation) {
            true -> {
                userLogined = true
                viewModelScope.launch {
                    roomRepository.addUser(
                        UserEntity(
                            userId = 1,
                            firstName = firstName,
                            secondName = secondName,
                            phoneNumber = phoneNumber
                        )
                    )
                }
                userLogined = true
                return true
            }
            false -> return false
        }
    }
}