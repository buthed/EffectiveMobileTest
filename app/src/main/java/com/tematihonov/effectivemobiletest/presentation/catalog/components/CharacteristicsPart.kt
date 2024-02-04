package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Feedback
import com.tematihonov.effectivemobiletest.domain.models.Info
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.models.Price
import com.tematihonov.effectivemobiletest.presentation.app_components.AppDivider
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun CharacteristicsPart(catalogItem: Item) {
    Column {
        Text(
            text = stringResource(id = R.string.product_page_characteristics),
            style = Typography.titleMedium,
            color = MaterialTheme.colors.textBlack
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            repeat(catalogItem.info.size) { number ->
                CharacteristicsItem(catalogItem.info[number])
            }
        }
    }
}

@Composable
fun CharacteristicsItem(info: Info) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = info.title,
                style = Typography.bodyMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
            Text(
                text = info.value,
                style = Typography.bodyMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
        }
        AppDivider(Modifier.padding(top = 12.dp, bottom = 4.dp))
    }
}

@Composable
@Preview
fun CharacteristicsPartPreview() {
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
    CharacteristicsPart(catalogItem)
}