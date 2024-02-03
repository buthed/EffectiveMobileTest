package com.tematihonov.effectivemobiletest.presentation.favorite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun GoodsBrandsSlider(goodsSelected: Boolean, selectCategory: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.bgLightGray)
            .padding(3.dp)
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(
                when (goodsSelected) {
                    true -> MaterialTheme.colors.bgWhite
                    false -> MaterialTheme.colors.bgLightGray
                }
            )
            .clickable(onClick = { selectCategory(true) })
        ) {
            Text(
                text = stringResource(id = R.string.favorite_goods),
                style = Typography.displayLarge,
                color = when (goodsSelected) {
                    true -> MaterialTheme.colors.textBlack
                    false -> MaterialTheme.colors.textGrey
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 9.dp),
                textAlign = TextAlign.Center
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(
                when (goodsSelected) {
                    true -> MaterialTheme.colors.bgLightGray
                    false -> MaterialTheme.colors.bgWhite
                }
            )
            .clickable(onClick = { selectCategory(false) })
        ) {
            Text(
                text = stringResource(id = R.string.favorite_brands),
                style = Typography.displayLarge,
                color = when (goodsSelected) {
                    true -> MaterialTheme.colors.textGrey
                    false -> MaterialTheme.colors.textBlack
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 9.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun GoodsBrandsSliderPreview() {
    GoodsBrandsSlider(goodsSelected = true) {}
}