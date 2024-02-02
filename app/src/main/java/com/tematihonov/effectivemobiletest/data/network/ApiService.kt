package com.tematihonov.effectivemobiletest.data.network

import com.tematihonov.effectivemobiletest.domain.models.ResponseCatalogList
import com.tematihonov.effectivemobiletest.utils.RetrofitConstants.GET_ALL_DATA
import retrofit2.http.GET

interface ApiService {

    @GET(GET_ALL_DATA)
    suspend fun getCatalogList(): ResponseCatalogList
}