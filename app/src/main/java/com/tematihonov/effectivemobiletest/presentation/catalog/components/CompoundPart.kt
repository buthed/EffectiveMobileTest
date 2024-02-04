package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun CompoundPart(catalogItem: Item) { // TODO check point 5.27 (hide - details visibility)
    var partVisibility by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.product_page_compound),
                style = Typography.titleMedium,
                color = MaterialTheme.colors.textBlack
            )
            Image(
                painter = painterResource(id = R.drawable.icon_copy), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = catalogItem.ingredients,
            style = Typography.bodyMedium, color = MaterialTheme.colors.textDarkGrey,
            maxLines = when (partVisibility) {
                true -> 20
                false -> 2
            },
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = stringResource(
                id = when (partVisibility) { //TODO add
                    true -> R.string.product_page_hide
                    false -> R.string.product_page_details
                }
            ),
            style = Typography.displaySmall, color = MaterialTheme.colors.textGrey,
            modifier = Modifier.clickable { partVisibility = !partVisibility })
    }
}

@Preview
@Composable
fun CompoundPartPreview() {
    //CompoundPart(catalogItem)
}