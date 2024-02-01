package com.tematihonov.effectivemobiletest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tematihonov.effectivemobiletest.presentation.basket.BasketScreen
import com.tematihonov.effectivemobiletest.presentation.catalog.CatalogScreen
import com.tematihonov.effectivemobiletest.presentation.login.LoginScreen
import com.tematihonov.effectivemobiletest.presentation.main.MainScreen
import com.tematihonov.effectivemobiletest.presentation.profile.ProfileScreen
import com.tematihonov.effectivemobiletest.presentation.promotions.PromotionsScreen

@Composable
fun EffectiveMTestNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "catalog"
    ) {
        composable("main") { MainScreen(navController) }
        composable("catalog") { CatalogScreen(navController) }
        composable("basket") { BasketScreen(navController) }
        composable("promotions") { PromotionsScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("login") { LoginScreen() }
    }
}