package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.mapper.parseIdToImageList
import com.tematihonov.effectivemobiletest.presentation.app_components.Discount
import com.tematihonov.effectivemobiletest.presentation.app_components.SmallEllipse
import com.tematihonov.effectivemobiletest.presentation.app_components.StarRating
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun CatalogScreenItem(catalogItem: Item) {
    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.bgWhite)
            .width(168.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colors.bgLightGray)
    ) {
        Box(
            modifier = Modifier
                .height(144.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = parseIdToImageList(catalogItem.id)[0]), contentDescription = "",//TODO add carousel
                contentScale = ContentScale.FillWidth
            ) //TODO add
            Row {
                repeat(2) {
                    SmallEllipse()
                }
            }
            Box(
                modifier = Modifier
                    .height(144.dp)
                    .width(168.dp), contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_heart), contentDescription = "", //TODO add favorites
                    modifier = Modifier.padding(6.dp)
                )
            }
        }
        Column(
            modifier = Modifier.background(MaterialTheme.colors.bgWhite).height(144.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 6.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text("${catalogItem.price.price} ${catalogItem.price.unit}", style = Typography.labelSmall, color = MaterialTheme.colors.textGrey)
                    Image(
                        painter = painterResource(id = R.drawable.crossed_out),
                        contentDescription = ""
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "${catalogItem.price.priceWithDiscount} ${catalogItem.price.unit}", style = Typography.titleSmall)
                    Discount(catalogItem.price.discount)
                }
                Text(text = catalogItem.title, style = Typography.headlineSmall)
                Text(
                    text = catalogItem.subtitle,
                    style = Typography.bodySmall,
                    modifier = Modifier.height(37.dp)
                )
                StarRating(catalogItem.feedback.rating, catalogItem.feedback.count)
            }
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 8.dp))
                        .background(MaterialTheme.colors.bgPink)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_plus),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp),
                        tint = MaterialTheme.colors.elementWhite
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun CatalogScreenItemPreview() {
    //CatalogScreenItem(catalogItem)
}