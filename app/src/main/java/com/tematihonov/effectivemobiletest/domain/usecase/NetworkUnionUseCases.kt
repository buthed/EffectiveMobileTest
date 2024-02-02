package com.tematihonov.effectivemobiletest.domain.usecase

import com.tematihonov.effectivemobiletest.domain.usecase.network.GetCatalogListUseCase

data class NetworkUnionUseCases(
    val getCatalogList: GetCatalogListUseCase
)