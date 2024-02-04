package com.tematihonov.effectivemobiletest.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.presentation.app_components.TopAppBar
import com.tematihonov.effectivemobiletest.ui.colors

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(stringResource(id = R.string.nav_main))
        },
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.nav_main))
        }
    }
}