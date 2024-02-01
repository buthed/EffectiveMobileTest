package com.tematihonov.effectivemobiletest.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {

    var userLogined by mutableStateOf(false)

    init {

    }

    fun testUserLogin() {

    }
}