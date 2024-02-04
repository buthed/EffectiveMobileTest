package com.tematihonov.effectivemobiletest.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tematihonov.effectivemobiletest.navigation.EffectiveMTestNavHost
import com.tematihonov.effectivemobiletest.navigation.Screen
import com.tematihonov.effectivemobiletest.presentation.app_components.BottomNavigationBar
import com.tematihonov.effectivemobiletest.presentation.app_components.ProgressIndicator
import com.tematihonov.effectivemobiletest.presentation.login.LoginScreen
import com.tematihonov.effectivemobiletest.presentation.login.LoginViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val bottomBarItems = listOf(
        Screen.Main,
        Screen.Catalog,
        Screen.Basket,
        Screen.Promotions,
        Screen.Profile
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