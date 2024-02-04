package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun CatalogSortAndFilter(currentSort: String, selectCurrentSort: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.bgWhite),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.clickable { expanded = true },
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_sort_by), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = currentSort,
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
            Image(
                painter = painterResource(id = R.drawable.icon_down), contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
        }
        DropdownMenu(
            modifier = Modifier.background(MaterialTheme.colors.bgLightGray),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Text(
                stringResource(id = R.string.catalog_sort_rating),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey,
                modifier = Modifier
                    .padding(start = 32.dp, end = 28.dp, bottom = 10.dp)
                    .clickable(onClick = {
                        expanded = false
                        selectCurrentSort("По популярности")
                    })
            )
            Text(
                stringResource(id = R.string.catalog_sort_increase),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey,
                modifier = Modifier
                    .padding(start = 32.dp, end = 28.dp, bottom = 10.dp)
                    .clickable(onClick = {
                        expanded = false
                        selectCurrentSort("По увеличению")
                    })
            )
            Text(
                stringResource(id = R.string.catalog_sort_decrease),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey,
                modifier = Modifier
                    .padding(start = 32.dp, end = 28.dp, bottom = 10.dp)
                    .clickable(onClick = {
                        expanded = false
                        selectCurrentSort("По уменьшению")
                    })
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_filter), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = stringResource(id = R.string.catalog_filter),
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textDarkGrey
            )
        }
    }
}