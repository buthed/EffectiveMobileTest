package com.tematihonov.effectivemobiletest.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.navigation.BottomNavItem
import com.tematihonov.effectivemobiletest.navigation.EffectiveMTestNavHost
import com.tematihonov.effectivemobiletest.presentation.app_components.BottomNavigationBar
import com.tematihonov.effectivemobiletest.presentation.app_components.ProgressIndicator
import com.tematihonov.effectivemobiletest.presentation.login.LoginScreen
import com.tematihonov.effectivemobiletest.presentation.login.LoginViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
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
    val viewModel = hiltViewModel<LoginViewModel>()

    when (viewModel.userLoginedChecking) {

        true -> { ProgressIndicator() }

        false -> {
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

                false -> { LoginScreen() { viewModel.userLogin() } }
            }
        }
    }
}