package com.tematihonov.effectivemobiletest.presentation.catalog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.presentation.app_components.ProgressIndicator
import com.tematihonov.effectivemobiletest.presentation.app_components.TopAppBar
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CatalogScreenItem
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CatalogScreenTags
import com.tematihonov.effectivemobiletest.presentation.catalog.components.CatalogSortAndFilter
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.utils.Resource

@Composable
fun CatalogScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<CatalogViewModel>()
    Scaffold(
        topBar = {
            TopAppBar(stringResource(id = R.string.catalog_title))
        },
        containerColor = MaterialTheme.colors.bgWhite,
        contentColor = MaterialTheme.colors.bgWhite,
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding() + 10.dp,
                    bottom = it.calculateBottomPadding() + 55.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .background(MaterialTheme.colors.bgWhite)
        ) {
            CatalogSortAndFilter(viewModel.selectedSort) { viewModel.sortCatalog(it) }
            Spacer(modifier = Modifier.size(17.dp))

            CatalogScreenTags(viewModel.selectedTag) {
                viewModel.filterCatalogByTag(it)
            }
            Spacer(modifier = Modifier.size(32.dp))

            when (val catalogListResponse = viewModel.catalogList.value) {
                is Resource.Error -> {  }
                is Resource.Loading -> { ProgressIndicator() }
                is Resource.Success -> {
                    catalogListResponse.data?.let { catalogList ->
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(7.dp),
                            horizontalArrangement = Arrangement.spacedBy(7.dp)
                        ) {
                            items(catalogList) { catalogItem ->
                                CatalogScreenItem(catalogItem = catalogItem,
                                    productInFavorites = viewModel.checkProductForFavoriteStatus(
                                        catalogItem
                                    ),
                                    favoriteButton = { viewModel.addDeleteToFavorites(catalogItem) }) {
                                    viewModel.openProductPage(catalogItem)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    AnimatedVisibility(viewModel.itemSelectedStatus) {
        ProductScreen(
            catalogItem = viewModel.selectedItem,
            productInFavorites = viewModel.selectedItem?.let {
                viewModel.checkProductForFavoriteStatus(
                    it
                )
            } == true,
            favoriteButton = { viewModel.selectedItem?.let { viewModel.addDeleteToFavorites(it) } }
        ) { viewModel.closeProductPage() }
    }

    LaunchedEffect(Unit) {
        viewModel.loadCatalogList()
    }
}

@Composable
@Preview
fun CatalogScreenPreview() {
    val navController = rememberNavController()
    CatalogScreen(navController)
}