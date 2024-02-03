package com.tematihonov.effectivemobiletest.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tematihonov.effectivemobiletest.data.local.UserEntity
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val roomRepository: RoomRepository
): ViewModel() {

    var currentUser: UserEntity? by mutableStateOf(null)

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        viewModelScope.launch {
            currentUser = roomRepository.getUserInfo()
        }
    }

    fun deleteDatabase(navController: NavHostController) {
        viewModelScope.launch {
            roomRepository.deleteUser()
            roomRepository.deleteAllFavoritesItems()
            navController.popBackStack("main", false)
        }
    }
}