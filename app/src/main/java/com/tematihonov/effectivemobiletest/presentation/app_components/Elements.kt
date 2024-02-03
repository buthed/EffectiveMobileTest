package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import kotlin.math.roundToInt

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
            painter = painterResource(id = R.drawable.icon_star_full), contentDescription = "",
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
fun StarRatingLong(averageRating: Double, qtyReviews: Int) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val filledStars = if ((averageRating/1.0)%1.0==0.5)  (averageRating/1.0).roundToInt()-1
            else (averageRating/1.0).roundToInt()

            repeat(filledStars) {
                Image(
                    painter = painterResource(id = R.drawable.icon_star_full), contentDescription = "",
                    modifier = Modifier.size(16.dp)
                )
            }
            if ((averageRating - filledStars) in 0.2..0.8) {
                Image(
                    painter = painterResource(id = R.drawable.icon_star_half), contentDescription = "",
                    modifier = Modifier.size(16.dp)
                )

            }
            repeat(
                if (averageRating > (averageRating.roundToInt())) 4-filledStars
                else 5 - filledStars
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_star_full), contentDescription = "",
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colors.textGrey
                )
            }

            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "$averageRating",
                style = Typography.bodyMedium,
                color = MaterialTheme.colors.textGrey
            )
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colors.textGrey),
            ) {}
            Text(text = "$qtyReviews отзыва", style = Typography.bodyMedium, color = MaterialTheme.colors.textGrey) //TODO recheck qty -> string
        }
        Spacer(modifier = Modifier.size(16.dp))
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
        StarRatingLong(3.3, 5)
        StarRatingLong(4.0, 6)
        StarRatingLong(4.5, 7)
        StarRatingLong(5.0, 8)
        BigEllipse()
    }
}