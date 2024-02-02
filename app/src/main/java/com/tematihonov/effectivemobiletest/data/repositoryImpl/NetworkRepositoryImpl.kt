package com.tematihonov.effectivemobiletest.data.repositoryImpl

import com.tematihonov.effectivemobiletest.data.network.ApiService
import com.tematihonov.effectivemobiletest.domain.models.ResponseCatalogList
import com.tematihonov.effectivemobiletest.domain.repository.NetworkRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): NetworkRepository {

    override suspend fun getCatalogList(): ResponseCatalogList {
        return apiService.getCatalogList()
    }
}