package com.tematihonov.effectivemobiletest.presentation.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun CatalogScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "CatalogScreen")
    }
}