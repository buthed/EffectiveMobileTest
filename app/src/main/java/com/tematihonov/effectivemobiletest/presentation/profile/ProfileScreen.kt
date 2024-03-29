package com.tematihonov.effectivemobiletest.presentation.profile

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.presentation.app_components.ButtonExit
import com.tematihonov.effectivemobiletest.presentation.app_components.TopAppBar
import com.tematihonov.effectivemobiletest.presentation.favorite.FavoriteScreen
import com.tematihonov.effectivemobiletest.presentation.profile.components.CommonTab
import com.tematihonov.effectivemobiletest.presentation.profile.components.FavoriteTab
import com.tematihonov.effectivemobiletest.presentation.profile.components.UserTab
import com.tematihonov.effectivemobiletest.ui.colors
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<ProfileViewModel>()
    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(stringResource(id = R.string.personal_account_title))
        },
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding() + 24.dp,
                    bottom = it.calculateBottomPadding() + 65.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                UserTab(viewModel.currentUser)
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    FavoriteTab(viewModel.favoriteList.size) {
                        viewModel.favoriteScreenVisibility = true
                    }
                    CommonTab(
                        R.drawable.icon_shop,
                        stringResource(id = R.string.personal_account_shops)
                    )
                    CommonTab(
                        R.drawable.icon_feedback,
                        stringResource(id = R.string.personal_account_feedback)
                    )
                    CommonTab(
                        R.drawable.icon_offer,
                        stringResource(id = R.string.personal_account_offer)
                    )
                    CommonTab(
                        R.drawable.icon_refund,
                        stringResource(id = R.string.personal_account_purchase_returns)
                    )
                }
            }
            ButtonExit() {
                coroutine.launch {
                    viewModel.deleteDatabase()
                    delay(500)
                    restartApp(context)
                }
            }
        }
        Box(modifier = Modifier.padding(paddingValues = it))
    }
    AnimatedVisibility(visible = viewModel.favoriteScreenVisibility) {
        FavoriteScreen(viewModel)
    }
}


private fun restartApp(context: Context) {
    val packageManager: PackageManager = context.packageManager
    val intent: Intent = packageManager.getLaunchIntentForPackage(context.packageName)!!
    val componentName: ComponentName = intent.component!!
    val restartIntent: Intent = Intent.makeRestartActivityTask(componentName)
    context.startActivity(restartIntent)
    Runtime.getRuntime().exit(0)
}

@Composable
@Preview
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}