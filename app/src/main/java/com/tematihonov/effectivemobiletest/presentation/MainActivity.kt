package com.tematihonov.effectivemobiletest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.navigation.BottomNavItem
import com.tematihonov.effectivemobiletest.navigation.EffectiveMTestNavHost
import com.tematihonov.effectivemobiletest.presentation.app_components.BottomNavigationBar
import com.tematihonov.effectivemobiletest.presentation.login.LoginScreen
import com.tematihonov.effectivemobiletest.ui.theme.EffectiveMobileTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveMobileTestTheme {
                val bottomBarItems = listOf(
                    BottomNavItem(
                        name = stringResource(id = R.string.nav_main),
                        route = "main",
                        icon = R.drawable.icon_home
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.nav_catalog),
                        route = "catalog",
                        icon = R.drawable.icon_catalog
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.nav_basket),
                        route = "basket",
                        icon = R.drawable.icon_bag
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.nav_promotions),
                        route = "promotions",
                        icon = R.drawable.icon_discount
                    ),
                    BottomNavItem(
                        name = stringResource(id = R.string.nav_profile),
                        route = "profile",
                        icon = R.drawable.icon_account
                    ),
                )
                val navController = rememberNavController()

                val viewModel = hiltViewModel<LoginViewModel>()

                when (viewModel.userLogined) {
                    true -> {
                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            bottomBar = {
                                BottomNavigationBar(
                                    modifier = Modifier.height(56.dp),
                                    items = bottomBarItems,
                                    navController = navController,
                                    onItemClick = {
                                        navController.navigate(it.route)
                                    })
                            },
                        ) { paddingValues ->
                            EffectiveMTestNavHost(navController = navController, paddingValues)
                        }
                    }

                    false -> {
                        LoginScreen()
                    }
                }
            }
        }
    }
}