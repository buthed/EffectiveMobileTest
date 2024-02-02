package com.tematihonov.effectivemobiletest.domain.repository

import com.tematihonov.effectivemobiletest.domain.models.ResponseCatalogList

interface NetworkRepository {

    suspend fun getCatalogList(): ResponseCatalogList
}