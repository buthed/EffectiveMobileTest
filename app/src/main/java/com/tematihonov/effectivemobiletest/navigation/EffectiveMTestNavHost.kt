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
        startDestination = "main"
    ) {
        composable("main") { MainScreen() }
        composable("catalog") { CatalogScreen() }
        composable("basket") { BasketScreen() }
        composable("promotions") { PromotionsScreen() }
        composable("profile") { ProfileScreen() }
    }
}