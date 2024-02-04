package com.tematihonov.effectivemobiletest.presentation.app_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tematihonov.effectivemobiletest.navigation.Screen
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun BottomNavigationBar(
    items: List<Screen>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (Screen) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon), contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            tint = if (selected) MaterialTheme.colors.textPink else MaterialTheme.colors.textDarkGrey
                        )
                        Text(
                            text = stringResource(id = item.name), style = Typography.labelMedium,
                            color = if (selected) MaterialTheme.colors.textPink else MaterialTheme.colors.textDarkGrey
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colors.textPink,
                    selectedTextColor = MaterialTheme.colors.textPink,
                    unselectedTextColor = MaterialTheme.colors.textDarkGrey,
                    indicatorColor = MaterialTheme.colors.bgWhite,
                )
            )
        }
    }
}