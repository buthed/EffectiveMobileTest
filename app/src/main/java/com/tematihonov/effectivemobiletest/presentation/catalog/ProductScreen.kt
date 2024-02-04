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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Feedback
import com.tematihonov.effectivemobiletest.domain.models.Info
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.models.Price
import com.tematihonov.effectivemobiletest.mapper.parseIdToImageList
import com.tematihonov.effectivemobiletest.mapper.productAvailableMapper
import com.tematihonov.effectivemobiletest.presentation.app_components.AppDivider
import com.tematihonov.effectivemobiletest.presentation.app_components.ButtonAddToBasket
import com.tematihonov.effectivemobiletest.presentation.app_components.CatalogItemTopAppBar
import com.tematihonov.effectivemobiletest.presentation.app_components.Discount
import com.tematihonov.effectivemobiletest.presentation.app_components.ProgressIndicator
import com.tematihonov.effectivemobiletest.presentation.app_components.StarRatingLong
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CharacteristicsPart
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CompoundPart
import com.tematihonov.effectivemobiletest.presentation.catalog.components.DescriptionPart
import com.tematihonov.effectivemobiletest.presentation.catalog.components.ViewPager
import com.tematihonov.effectivemobiletest.presentation.catalog.components.ViewPagerPagination
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun ProductScreen(
    catalogItem: Item?,
    productInFavorites: Boolean,
    favoriteButton: () -> Unit,
    backClick: () -> Unit,
) {
    var imagePage by remember { mutableIntStateOf(0) }

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

                            // ViewPager
                            ViewPager(
                                images = parseIdToImageList(catalogItem.id),
                                currentPage = imagePage
                            ) {
                                imagePage = it
                            }
                            Image(
                                painter = painterResource(
                                    id =
                                    when (productInFavorites) {
                                        true -> R.drawable.icon_heart_active
                                        false -> R.drawable.icon_heart
                                    }
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable(onClick = favoriteButton)
                            )
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
                    ViewPagerPagination(
                        images = parseIdToImageList(catalogItem.id),
                        currentPage = imagePage
                    )
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
                            text = "Доступно для заказа ${catalogItem.available} ${
                                productAvailableMapper(
                                    catalogItem.available
                                )
                            }",
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
                        Text(
                            text = "${catalogItem.price.priceWithDiscount} ${catalogItem.price.unit}",
                            style = Typography.headlineLarge,
                            color = MaterialTheme.colors.textBlack
                        )
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
                        ButtonAddToBasket(catalogItem.price)
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
    val catalogItem = Item(
        available = 100,
        description = "Лосьон для тела `ESFOLIO` COENZYME Q10 Увлажняющий содержит минеральную воду и соду, способствует глубокому очищению пор от различных загрязнений, контроллирует работу сальных желез, сужает поры. Обладает мягким антиептическим действием, не пересушивает кожу. Минеральная вода тонизирует и смягчает кожу.",
        feedback = Feedback(
            count = 51,
            rating = 4.5
        ),
        id = "cbf0c984-7c6c-4ada-82da-e29dc698bb50",
        info = listOf(
            Info(title = "Артикул товара", value = "441187"),
            Info(title = "Область использования", value = "Тело"),
            Info(title = "Страна производства", value = "Франция")
        ),
        ingredients = "Glycerin Palmitic Acid, Stearic Acid, Capric Acid, Sodium Benzoate",
        price = Price(price = "899", discount = 39, priceWithDiscount = "549", unit = "₽"),
        subtitle = "Лосьон для тела `ESFOLIO` COENZYME Q10 Увлажняющий 500 мл",
        tags = listOf("face"),
        title = "ESFOLIO"
    )
    ProductScreen(
        catalogItem = catalogItem,
        productInFavorites = false,
        favoriteButton = {},
        backClick = {},
    )
}