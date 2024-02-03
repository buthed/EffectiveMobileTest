package com.tematihonov.effectivemobiletest.di

import android.content.Context
import androidx.room.Room
import com.tematihonov.effectivemobiletest.data.local.EffectiveMobileTestAppDatabase
import com.tematihonov.effectivemobiletest.data.local.EffectiveMobileTestDao
import com.tematihonov.effectivemobiletest.data.repositoryImpl.RoomRepositoryImpl
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import com.tematihonov.effectivemobiletest.utils.RoomConstants.APP_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun effectiveMobileTestDataBase(@ApplicationContext context: Context): EffectiveMobileTestAppDatabase {
        return Room.databaseBuilder(
            context,
            EffectiveMobileTestAppDatabase::class.java,
            APP_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun effectiveMobileTest(effectiveMobileTestDataBase: EffectiveMobileTestAppDatabase): EffectiveMobileTestDao {
        return effectiveMobileTestDataBase.effectiveMobileTestDao()
    }

    @Singleton
    @Provides
    fun provideLocalRepositoryImpl(repository: RoomRepositoryImpl): RoomRepository {
        return repository
    }
}