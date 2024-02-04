package com.tematihonov.effectivemobiletest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tematihonov.effectivemobiletest.presentation.basket.BasketScreen
import com.tematihonov.effectivemobiletest.presentation.catalog.CatalogScreen
import com.tematihonov.effectivemobiletest.presentation.main.MainScreen
import com.tematihonov.effectivemobiletest.presentation.profile.ProfileScreen
import com.tematihonov.effectivemobiletest.presentation.promotions.PromotionsScreen

@Composable
fun EffectiveMTestNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screen.Catalog.route
    ) {
        composable(Screen.Main.route) { MainScreen(navController) }
        composable(Screen.Catalog.route) { CatalogScreen(navController) }
        composable(Screen.Basket.route) { BasketScreen(navController) }
        composable(Screen.Promotions.route) { PromotionsScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
    }
}