package com.tematihonov.effectivemobiletest.presentation.catalog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography


@Composable
fun TagSelected(tagName: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.elementDarkBlue), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(start = 12.dp, top = 4.dp, bottom = 4.dp, end = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tagName,
                style = Typography.headlineMedium,
                color = MaterialTheme.colors.textWhite
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_small_close),
                contentDescription = "",
                tint = MaterialTheme.colors.bgWhite,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun TagUnselected(tagName: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.bgLightGray), contentAlignment = Alignment.Center
    ) {
        Text(
            text = tagName,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp),
            style = Typography.headlineMedium,
            color = MaterialTheme.colors.textGrey
        )
    }
}

@Composable
@Preview
fun TagUnselectedPreview() {
    TagUnselected("Unselected")
}

@Composable
@Preview
fun TagSelectedPreview() {
    TagSelected("Selected")
}