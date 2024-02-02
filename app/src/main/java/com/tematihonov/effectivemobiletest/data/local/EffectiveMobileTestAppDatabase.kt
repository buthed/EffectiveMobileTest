package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class,FavoritesEntity::class], version = 1, exportSchema = false)
abstract class EffectiveMobileTestAppDatabase: RoomDatabase() {

    abstract fun effectiveMobileTestDao(): EffectiveMobileTestDao
}