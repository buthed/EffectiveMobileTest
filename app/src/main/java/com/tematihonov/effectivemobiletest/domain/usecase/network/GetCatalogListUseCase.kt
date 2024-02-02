package com.tematihonov.effectivemobiletest.domain.usecase.network

import com.tematihonov.effectivemobiletest.domain.models.ResponseCatalogList
import com.tematihonov.effectivemobiletest.domain.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCatalogListUseCase @Inject constructor(
    private val networkRepository: NetworkRepository
) {

    suspend fun invoke(): Flow<ResponseCatalogList> = flow {
        emit(networkRepository.getCatalogList())
    }.flowOn(Dispatchers.IO)
}