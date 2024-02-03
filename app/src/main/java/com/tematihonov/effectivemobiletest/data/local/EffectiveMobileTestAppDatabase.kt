package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Database(entities = [UserEntity::class,ProductEntity::class], version = 1, exportSchema = false)
abstract class EffectiveMobileTestAppDatabase: RoomDatabase() {

    abstract fun effectiveMobileTestDao(): EffectiveMobileTestDao
}