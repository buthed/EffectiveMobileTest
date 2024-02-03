package com.tematihonov.effectivemobiletest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.tematihonov.effectivemobiletest.presentation.home.HomeScreen
import com.tematihonov.effectivemobiletest.ui.theme.EffectiveMobileTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveMobileTestTheme {
                val navController = rememberNavController()
                HomeScreen(navController)
            }
        }
    }
}