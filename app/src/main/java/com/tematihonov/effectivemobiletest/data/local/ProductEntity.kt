package com.tematihonov.effectivemobiletest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tematihonov.effectivemobiletest.domain.models.Feedback
import com.tematihonov.effectivemobiletest.domain.models.Info
import com.tematihonov.effectivemobiletest.domain.models.Price
import com.tematihonov.effectivemobiletest.utils.RoomConstants.PRODUCT_TABLE_NAME

@Entity(tableName = PRODUCT_TABLE_NAME)
data class ProductEntity(
    val available: Int,
    val description: String,
    val feedback: Feedback,
    @PrimaryKey
    val id: String,
    val info: List<Info>,
    val ingredients: String,
    val price: Price,
    val subtitle: String,
    val tags: List<String>,
    val title: String,
)