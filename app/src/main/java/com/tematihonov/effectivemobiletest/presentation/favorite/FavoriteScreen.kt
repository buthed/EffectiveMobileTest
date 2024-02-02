package com.tematihonov.effectivemobiletest.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.presentation.app_components.FavoriteTopAppBar
import com.tematihonov.effectivemobiletest.ui.colors

@Composable
fun FavoriteScreen() {
    Scaffold(
        topBar = {
            FavoriteTopAppBar { }
        },
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        Box(
            modifier = Modifier.padding(
                top = it.calculateTopPadding() + 62.dp,
                bottom = it.calculateBottomPadding()
            )
        ) {
            LazyColumn() {}
        }
    }
}

@Composable
@Preview
fun FavoriteScreenPreview() {
    FavoriteScreen()
}
