package com.tematihonov.effectivemobiletest.domain.models

data class Price(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)