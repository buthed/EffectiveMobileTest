package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun EmTopAppBar(title: String) {
    Text(
        text = title,
        style = Typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 10.dp),
        textAlign = TextAlign.Center
    )
}