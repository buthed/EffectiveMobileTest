package com.tematihonov.effectivemobiletest.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.data.local.UserEntity
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun UserTab(currentUser: UserEntity?) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colors.bgLightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 7.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_account), contentDescription = "",
                modifier = Modifier.size(24.dp), tint = MaterialTheme.colors.elementDarkGray
            )
            if (currentUser != null) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = "${currentUser.firstName} ${currentUser.secondName}", style = Typography.titleSmall) //TODO add
                    Text(
                        text = "+7 993 877 44 02",
                        style = Typography.bodySmall,
                        color = MaterialTheme.colors.textGrey
                    ) //TODO add
                }
            }

        }
        Icon(
            painter = painterResource(id = R.drawable.icon_log_out), contentDescription = "",
            modifier = Modifier.size(32.dp), tint = MaterialTheme.colors.elementDarkGray
        )
    }
}

@Composable
fun FavoriteTab() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colors.bgLightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 7.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_account), contentDescription = "",
                modifier = Modifier.size(24.dp), tint = MaterialTheme.colors.elementDarkGray
            )
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = stringResource(id = R.string.favorite_title),
                    style = Typography.titleSmall
                )
                Text(
                    text = "1 товар",
                    style = Typography.bodySmall,
                    color = MaterialTheme.colors.textGrey
                ) //TODO add
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.icon_right_arrow), contentDescription = "",
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp), tint = MaterialTheme.colors.elementDarkGray
        )
    }
}

@Composable
fun CommonTab(icon: Int, title: String) { //TODO add image colors
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colors.bgLightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 7.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon), contentDescription = "",
                modifier = Modifier.size(24.dp), tint = MaterialTheme.colors.elementDarkGray
            )
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(text = title, style = Typography.titleSmall)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.icon_right_arrow), contentDescription = "",
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp)
        )
    }
}

@Composable
@Preview
fun UserTabPreview() {
    UserTab(UserEntity(1, "Марина", "Иванова", "993 877 44 02"))
}

@Composable
@Preview
fun FavoriteTabPreview() {
    FavoriteTab()
}

@Composable
@Preview
fun CommonTabPreview() {
    CommonTab(R.drawable.icon_shop, stringResource(id = R.string.personal_account_shops))
}