package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tematihonov.effectivemobiletest.utils.RoomConstants.PRODUCT_TABLE_NAME
import com.tematihonov.effectivemobiletest.utils.RoomConstants.USER_TABLE_NAME

@Dao
interface EffectiveMobileTestDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewFavorite(productEntity: ProductEntity)

    @Query("SELECT * FROM $PRODUCT_TABLE_NAME")
    suspend fun selectAllFavoritesItems(): List<ProductEntity>

    @Query("DELETE FROM $PRODUCT_TABLE_NAME")
    suspend fun deleteAllFavoritesItems()

    @Query("DELETE FROM $PRODUCT_TABLE_NAME WHERE id = :id")
    suspend fun deleteItemFromFavorites(id: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM $USER_TABLE_NAME WHERE userId == 1")
    suspend fun getUserInfo(): UserEntity

    @Query("SELECT (SELECT COUNT(*) FROM $USER_TABLE_NAME) == 0")
    suspend fun checkUserLogin(): Boolean

    @Query("DELETE FROM $USER_TABLE_NAME")
    suspend fun deleteUser()
}