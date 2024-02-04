package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Feedback
import com.tematihonov.effectivemobiletest.domain.models.Info
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.models.Price
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun DescriptionPart(catalogItem: Item) {
    var partVisibility by remember { mutableStateOf(true) }

    Column {
        Text(
            text = stringResource(id = R.string.catalog_description),
            style = Typography.titleMedium,
            color = MaterialTheme.colors.textBlack
        )
        Spacer(modifier = Modifier.size(10.dp))
        if (partVisibility) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colors.bgLightGray),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = catalogItem.title,
                        style = Typography.titleSmall,
                        color = MaterialTheme.colors.textBlack
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_right_arrow),
                        contentDescription = "",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = catalogItem.description,
                style = Typography.bodyMedium, color = MaterialTheme.colors.textDarkGrey
            )
            Spacer(modifier = Modifier.size(10.dp))
        }
        Text(text = stringResource(
            id =
            when (partVisibility) {
                true -> R.string.product_page_hide
                false -> R.string.product_page_details
            }
        ),
            style = Typography.displaySmall,
            color = MaterialTheme.colors.textGrey,
            modifier = Modifier.clickable { partVisibility = !partVisibility })
    }
}

@Composable
@Preview
fun ToBrandButtonPreview() {
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
    DescriptionPart(catalogItem)
}