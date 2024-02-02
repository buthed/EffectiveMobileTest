package com.tematihonov.effectivemobiletest.data.repositoryImpl

import com.tematihonov.effectivemobiletest.data.local.EffectiveMobileTestDao
import com.tematihonov.effectivemobiletest.data.local.FavoritesEntity
import com.tematihonov.effectivemobiletest.data.local.UserEntity
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomRepositoryImpl @Inject constructor(
    private val effectiveMobileTestDao: EffectiveMobileTestDao
): RoomRepository {

    override suspend fun addNewFavorite(favoritesEntity: FavoritesEntity) {
        effectiveMobileTestDao.addNewFavorite(favoritesEntity)
    }

    override fun selectAllFavoritesItems(): FavoritesEntity {
        return effectiveMobileTestDao.selectAllFavoritesItems()
    }

    override fun deleteAllFavoritesItems() {
        effectiveMobileTestDao.deleteAllFavoritesItems()
    }

    override fun deleteItemFromFavorites(id: Int) {
        effectiveMobileTestDao.deleteItemFromFavorites(id)
    }

    override suspend fun addUser(userEntity: UserEntity) {
        effectiveMobileTestDao.addUser(userEntity)
    }

    override fun checkUserLogin(): UserEntity {
        return effectiveMobileTestDao.checkUserLogin()
    }

    override fun deleteUser() {
        effectiveMobileTestDao.deleteUser()
    }
}