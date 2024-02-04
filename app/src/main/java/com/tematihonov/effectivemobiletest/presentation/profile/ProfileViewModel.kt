package com.tematihonov.effectivemobiletest.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.tematihonov.effectivemobiletest.data.local.ProductEntity
import com.tematihonov.effectivemobiletest.data.local.UserEntity
import com.tematihonov.effectivemobiletest.data.mapper.toProductEntity
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val roomRepository: RoomRepository,
) : ViewModel() {

    var currentUser: UserEntity? by mutableStateOf(null)
    var favoriteList by mutableStateOf(emptyList<ProductEntity>())

    var favoriteScreenVisibility by mutableStateOf(false)
    var favoriteScreenGoodsSelected by mutableStateOf(true)

    init {
        getUserInfo()
        loadFavoriteList()
    }

    fun checkProductForFavoriteStatus(catalogItem: Item): Boolean {
        return when (favoriteList.contains(catalogItem.toProductEntity())) {
            true -> true
            false -> false
        }
    }

    fun deleteFromFavorites(catalogItem: Item) {
        viewModelScope.launch {
            roomRepository.deleteItemFromFavorites(catalogItem.id)
            loadFavoriteList()
        }
    }

    fun getUserInfo() {
        viewModelScope.launch {
            currentUser = roomRepository.getUserInfo()
        }
    }

    fun deleteDatabase() {
        viewModelScope.launch {
            roomRepository.deleteAllFavoritesItems()
            roomRepository.deleteUser()
        }
    }

    fun loadFavoriteList() {
        viewModelScope.launch {
            favoriteList = roomRepository.selectAllFavoritesItems()
        }
    }
}