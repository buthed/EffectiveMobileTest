package com.tematihonov.effectivemobiletest.data.mapper

import com.tematihonov.effectivemobiletest.data.local.ProductEntity
import com.tematihonov.effectivemobiletest.domain.models.Item

fun ProductEntity.toItem(): Item {
    return Item(
        available = this.available,
        description = this.description,
        feedback = this.feedback,
        id = this.id,
        info = this.info,
        ingredients = this.ingredients,
        price = this.price,
        subtitle = this.subtitle,
        tags = this.tags,
        title = this.title
    )
}

fun Item.toProductEntity(): ProductEntity {
    return ProductEntity(
        available = this.available,
        description = this.description,
        feedback = this.feedback,
        id = this.id,
        info = this.info,
        ingredients = this.ingredients,
        price = this.price,
        subtitle = this.subtitle,
        tags = this.tags,
        title = this.title
    )
}