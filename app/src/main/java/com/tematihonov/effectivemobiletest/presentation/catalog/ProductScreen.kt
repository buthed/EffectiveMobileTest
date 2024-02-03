package com.tematihonov.effectivemobiletest.presentation.catalog

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.mapper.parseIdToImageList
import com.tematihonov.effectivemobiletest.presentation.app_components.AppDivider
import com.tematihonov.effectivemobiletest.presentation.app_components.BigEllipse
import com.tematihonov.effectivemobiletest.presentation.app_components.ButtonAddToBasket
import com.tematihonov.effectivemobiletest.presentation.app_components.CatalogItemTopAppBar
import com.tematihonov.effectivemobiletest.presentation.app_components.Discount
import com.tematihonov.effectivemobiletest.presentation.app_components.ProgressIndicator
import com.tematihonov.effectivemobiletest.presentation.app_components.StarRatingLong
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CharacteristicsPart
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CompoundPart
import com.tematihonov.effectivemobiletest.presentation.catalog.components.DescriptionPart
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun ProductScreen(catalogItem: Item?, productInFavorites: Boolean, favoriteButton: () -> Unit, backClick: () -> Unit) { //TODO fix backpress action
    Scaffold(
        topBar = {
            CatalogItemTopAppBar(backClick = backClick)
        },
        containerColor = MaterialTheme.colors.bgWhite,
        contentColor = MaterialTheme.colors.bgWhite,
    ) {
        // Backpress handler
        BackHandler(onBack = backClick)

        when (catalogItem != null) {
            true -> {
                Column(
                    modifier = Modifier
                        .padding(
                            top = it.calculateTopPadding() + 16.dp,
                            start = 16.dp, end = 16.dp,
                            bottom = it.calculateBottomPadding() + 60.dp
                        )
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.Start
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(360.dp), contentAlignment = Alignment.BottomStart
                    ) {
                        Box(modifier = Modifier, contentAlignment = Alignment.TopEnd) {
                            Image(
                                painter = painterResource(id = parseIdToImageList(catalogItem.id)[0]),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(360.dp)
                            ) //TODO add carousel
                            Image(
                                painter = painterResource(id =
                                    when (productInFavorites) {
                                        true -> R.drawable.icon_heart_active
                                        false -> R.drawable.icon_heart
                                    }),
                                contentDescription = "", modifier = Modifier.size(24.dp).clickable(onClick = favoriteButton)
                            ) //TODO add room
                        }
                        Box(modifier = Modifier.padding(bottom = 16.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_question),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    // Pagination
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Row(
                            modifier = Modifier.padding(vertical = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(2) {//TODO add carousel
                                BigEllipse()
                            }
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = catalogItem.title,
                            style = Typography.titleMedium,
                            color = MaterialTheme.colors.textGrey
                        )
                        Text(
                            text = catalogItem.subtitle,
                            style = Typography.titleLarge,
                            color = MaterialTheme.colors.textBlack
                        )
                        Text(
                            text = "Доступно для заказа ${catalogItem.available} штук", //TODO add count -> to string парсер
                            style = Typography.bodyMedium,
                            color = MaterialTheme.colors.textGrey
                        )
                        AppDivider()
                        StarRatingLong(catalogItem.feedback.rating, catalogItem.feedback.count)

                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "${catalogItem.price.priceWithDiscount} ${catalogItem.price.unit}", style = Typography.headlineLarge,
                            color = MaterialTheme.colors.textBlack)
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                "${catalogItem.price.price} ${catalogItem.price.unit}",
                                style = Typography.bodyMedium, color = MaterialTheme.colors.textGrey
                            )
                            Image(
                                painter = painterResource(id = R.drawable.crossed_out),
                                contentDescription = ""
                            )
                        }
                        Discount(catalogItem.price.discount)
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(34.dp)) {
                        DescriptionPart(catalogItem)
                        CharacteristicsPart(catalogItem)
                        CompoundPart(catalogItem)
                        ButtonAddToBasket() {} //TODO add
                    }
                }
            }
            false -> {
                ProgressIndicator()
            }
        }
    }
}


@Composable
@Preview
fun CatalogItemScreenPreview() {
    //ProductScreen() {}
}