@file:OptIn(ExperimentalMaterial3Api::class)

package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun TopAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = Typography.titleMedium,
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 10.dp),
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colors.bgWhite)
    )
}

@Composable
fun FavoriteTopAppBar(backClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.favorite_title),
                style = Typography.titleMedium,
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp, start = 15.dp),
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.icon_left_arrow), contentDescription = "",
                modifier = Modifier.clickable(onClick = backClick).padding(start = 16.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colors.bgWhite)
    )
}

@Composable
fun CatalogItemTopAppBar(backClick: () -> Unit) {
    TopAppBar(
        title = { },
        navigationIcon = {
            Box(modifier = Modifier.padding(start = 15.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_left_arrow), contentDescription = "",
                    modifier = Modifier.clickable(onClick = backClick)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(painter = painterResource(id = R.drawable.icon_log_out), contentDescription = "",
                    modifier = Modifier.rotate(270f))
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colors.bgWhite)
    )
}

@Composable
@Preview
fun TopAppBarPreview() {
    TopAppBar("Вход")
}

@Composable
@Preview
fun FavoriteTopAppBarPreview() {
    FavoriteTopAppBar() {}
}

@Composable
@Preview
fun CatalogItemTopAppBarPreview() {
    CatalogItemTopAppBar() {}
}