package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Price
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun ButtonEnter(
    validateStatus: Boolean,
    buttonClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(
                when (validateStatus) {
                    true -> MaterialTheme.colors.bgPink
                    false -> MaterialTheme.colors.bgLightPink
                }
            )
            .clickable(onClick = buttonClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.entry_button),
            modifier = Modifier.padding(top = 18.dp, bottom = 15.dp, start = 10.dp, end = 10.dp),
            style = Typography.displayLarge, color = MaterialTheme.colors.textWhite
        )
    }
}

@Composable
fun ButtonExit(buttonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.bgLightGray)
            .clickable(onClick = buttonClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.personal_account_log_out),
            modifier = Modifier.padding(top = 18.dp, bottom = 15.dp, start = 10.dp, end = 10.dp),
            style = Typography.displayLarge, color = MaterialTheme.colors.textBlack
        )
    }
}

@Composable
fun ButtonAddToBasket(catalogItemPrice: Price) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colors.bgPink),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${catalogItemPrice.priceWithDiscount} ${catalogItemPrice.unit}",
                    style = Typography.displayLarge,
                    color = MaterialTheme.colors.textWhite
                )
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        "${catalogItemPrice.price} ${catalogItemPrice.unit}",
                        style = Typography.bodyMedium, color = MaterialTheme.colors.textLightPink
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.crossed_out),
                        contentDescription = "", tint = MaterialTheme.colors.bgLightPink
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.product_page_add_to_basket),
                style = Typography.displayLarge, color = MaterialTheme.colors.textWhite
            )
        }
    }
}


@Composable
@Preview
fun ButtonEnterPreview() {
    ButtonEnter(true) {

    }
}

@Composable
@Preview
fun ButtonExitPreview() {
    ButtonExit() {

    }
}

@Composable
@Preview
fun ButtonAddToBasketPreview() {
    //ButtonAddToBasket()
}