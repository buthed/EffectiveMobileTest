package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun EmButtonEnter(
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
@Preview
fun EmButtonEnterPreview() {
    EmButtonEnter(true) {

    }
}