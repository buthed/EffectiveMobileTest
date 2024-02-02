package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun CatalogSortAndFilter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.bgWhite),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.icon_sort_by), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.catalog_sort_rating),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.icon_filter), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.catalog_sort_rating),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
        }
    }
}