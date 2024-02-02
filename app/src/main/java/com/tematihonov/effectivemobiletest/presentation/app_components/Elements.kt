package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Discount(discount: Int) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.bgPink)
            .padding(horizontal = 6.dp, vertical = 3.dp)
    ) {
        Text("-$discount%", style = Typography.labelSmall, color = MaterialTheme.colors.textWhite)
    }
}

@Composable
fun SmallEllipse() {
    Box(
        modifier = Modifier
            .size(8.dp)
            .padding(2.dp)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.bgPink),
    ) {}
}

@Composable
fun StarRating(averageRating: Double, qtyReviews: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_star), contentDescription = "",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "$averageRating",
            style = Typography.labelSmall,
            color = MaterialTheme.colors.textOrange
        )
        Text(text = "($qtyReviews)", style = Typography.labelSmall)
    }
}

@Composable
fun BigEllipse() {
    Box(
        modifier = Modifier
            .size(10.dp)
            .padding(2.dp)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.bgPink),
    ) {}
}


@Preview
@Composable
fun ElementsPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Discount(discount = 35)
        SmallEllipse()
        StarRating(4.3, 4)
        BigEllipse()
    }
}