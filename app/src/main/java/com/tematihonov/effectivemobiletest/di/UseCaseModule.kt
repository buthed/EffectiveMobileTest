package com.tematihonov.effectivemobiletest.di

import com.tematihonov.effectivemobiletest.data.repositoryImpl.NetworkRepositoryImpl
import com.tematihonov.effectivemobiletest.domain.repository.NetworkRepository
import com.tematihonov.effectivemobiletest.domain.usecase.NetworkUnionUseCases
import com.tematihonov.effectivemobiletest.domain.usecase.network.GetCatalogListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideNetworkRepositoryImpl(repository: NetworkRepositoryImpl): NetworkRepository {
        return repository
    }

    @Singleton
    @Provides
    fun provideNetworkUseCases(networkRepository: NetworkRepository): NetworkUnionUseCases {
        return NetworkUnionUseCases(
            getCatalogList = GetCatalogListUseCase(networkRepository)
        )
    }
}