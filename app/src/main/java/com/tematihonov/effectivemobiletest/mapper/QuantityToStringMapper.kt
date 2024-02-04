package com.tematihonov.effectivemobiletest.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tematihonov.effectivemobiletest.R

@Composable
fun productAvailableMapper(producsAvailable: Int): String {
    return when {
        producsAvailable % 10 == 1 && producsAvailable % 100 != 11 -> stringResource(id = R.string.product_available_1)
        producsAvailable % 10 in 2..4 && producsAvailable % 100 !in 12..14 -> stringResource(id = R.string.product_available_2)
        else -> stringResource(id = R.string.product_available_0)
    }
}

@Composable
fun productFeedbackMapper(productFeedbacks: Int): String {
    return when {
        productFeedbacks % 10 == 1 && productFeedbacks % 100 != 11 -> stringResource(id = R.string.product_feedback_1)
        productFeedbacks % 10 in 2..4 && productFeedbacks % 100 !in 12..14 -> stringResource(id = R.string.product_feedback_2)
        else -> stringResource(id = R.string.product_feedback_0)
    }
}

@Composable
fun goodsMapper(goods: Int): String {
    return when {
        goods % 10 == 1 && goods % 100 != 11 -> stringResource(id = R.string.product_goods_1)
        goods % 10 in 2..4 && goods % 100 !in 12..14 -> stringResource(id = R.string.product_goods_2)
        else -> stringResource(id = R.string.product_goods_0)
    }
}

