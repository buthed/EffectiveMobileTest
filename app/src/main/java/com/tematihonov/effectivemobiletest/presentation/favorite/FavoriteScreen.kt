package com.tematihonov.effectivemobiletest.presentation.favorite

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.effectivemobiletest.data.mapper.toItem
import com.tematihonov.effectivemobiletest.presentation.app_components.FavoriteTopAppBar
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CatalogScreenItem
import com.tematihonov.effectivemobiletest.presentation.favorite.components.GoodsBrandsSlider
import com.tematihonov.effectivemobiletest.presentation.profile.ProfileViewModel
import com.tematihonov.effectivemobiletest.ui.colors

@Composable
fun FavoriteScreen(viewModel: ProfileViewModel) {
    Scaffold(
        topBar = { FavoriteTopAppBar { viewModel.favoriteScreenVisibility = false } },
        containerColor = MaterialTheme.colors.bgWhite
    ) {

        // Backpress handler
        BackHandler(onBack = { viewModel.favoriteScreenVisibility = false })
        Column(
            modifier = Modifier.padding(
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            GoodsBrandsSlider(goodsSelected = viewModel.favoriteScreenGoodsSelected) {
                viewModel.favoriteScreenGoodsSelected = it
            }
            when (viewModel.favoriteScreenGoodsSelected) {
                true -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(7.dp),
                        horizontalArrangement = Arrangement.spacedBy(7.dp)
                    ) {
                        items(viewModel.favoriteList) { favoriteItem ->
                            val item = favoriteItem.toItem()
                            CatalogScreenItem(catalogItem = item,
                                productInFavorites = viewModel.checkProductForFavoriteStatus(item),
                                favoriteButton = { viewModel.deleteFromFavorites(item) }) {}
                        }
                    }
                }
                false -> {}
            }

        }
    }
}

@Composable
@Preview
fun FavoriteScreenPreview() {
    val viewModel = hiltViewModel<ProfileViewModel>()
    FavoriteScreen(viewModel)
}
