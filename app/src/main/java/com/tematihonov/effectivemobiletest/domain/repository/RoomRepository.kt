package com.tematihonov.effectivemobiletest.domain.repository

import com.tematihonov.effectivemobiletest.data.local.ProductEntity
import com.tematihonov.effectivemobiletest.data.local.UserEntity

interface RoomRepository {

    suspend fun addNewFavorite(productEntity: ProductEntity)

    suspend fun selectAllFavoritesItems(): List<ProductEntity>

    suspend fun deleteAllFavoritesItems()

    suspend fun deleteItemFromFavorites(id: String)

    suspend fun addUser(userEntity: UserEntity)

    suspend fun getUserInfo(): UserEntity

    suspend fun checkUserLogin(): Boolean

    suspend fun deleteUser()
}