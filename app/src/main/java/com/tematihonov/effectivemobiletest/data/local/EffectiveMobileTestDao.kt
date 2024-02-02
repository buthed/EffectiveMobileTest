package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tematihonov.effectivemobiletest.utils.RoomConstants.FAVORITES_TABLE_NAME
import com.tematihonov.effectivemobiletest.utils.RoomConstants.USER_TABLE_NAME

@Dao
interface EffectiveMobileTestDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewFavorite(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM $FAVORITES_TABLE_NAME")
    fun selectAllFavoritesItems(): FavoritesEntity

    @Query("DELETE FROM $FAVORITES_TABLE_NAME")
    fun deleteAllFavoritesItems()

    @Query("DELETE FROM $FAVORITES_TABLE_NAME WHERE id = :id")
    fun deleteItemFromFavorites(id: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM $USER_TABLE_NAME")
    fun checkUserLogin(): UserEntity

    @Query("DELETE FROM $USER_TABLE_NAME")
    fun deleteUser()
}