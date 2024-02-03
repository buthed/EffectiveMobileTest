package com.tematihonov.effectivemobiletest.domain.repository

import com.tematihonov.effectivemobiletest.data.local.FavoritesEntity
import com.tematihonov.effectivemobiletest.data.local.UserEntity

interface RoomRepository {

    suspend fun addNewFavorite(favoritesEntity: FavoritesEntity)

    fun selectAllFavoritesItems(): FavoritesEntity

    suspend fun deleteAllFavoritesItems()

    fun deleteItemFromFavorites(id: Int)

    suspend fun addUser(userEntity: UserEntity)

    suspend fun getUserInfo(): UserEntity

    suspend fun checkUserLogin(): Boolean

    suspend fun deleteUser()
}