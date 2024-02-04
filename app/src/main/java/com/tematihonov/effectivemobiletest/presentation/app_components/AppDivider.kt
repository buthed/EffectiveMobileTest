package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.ui.colors

@Composable
fun AppDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        thickness = 1.dp,
        color = MaterialTheme.colors.elementLightGray
    )
}