package com.tematihonov.effectivemobiletest.presentation.catalog

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.effectivemobiletest.data.local.ProductEntity
import com.tematihonov.effectivemobiletest.data.mapper.toProductEntity
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.repository.RoomRepository
import com.tematihonov.effectivemobiletest.domain.usecase.NetworkUnionUseCases
import com.tematihonov.effectivemobiletest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val networkUnionUseCases: NetworkUnionUseCases,
    private val roomRepository: RoomRepository
): ViewModel() {

    val catalogList: MutableState<Resource<List<Item>>> = mutableStateOf(Resource.Loading())
    var favoriteList by mutableStateOf(emptyList<ProductEntity>())

    var selectedItem: Item? by mutableStateOf(null)
    var itemSelectedStatus by mutableStateOf(false)

    init {
        refreshFavoriteList()
    }

    fun addDeleteToFavorites(catalogItem: Item) {
        viewModelScope.launch {
            when (favoriteList.contains(catalogItem.toProductEntity())) {
                true -> roomRepository.deleteItemFromFavorites(catalogItem.id)
                false -> roomRepository.addNewFavorite(catalogItem.toProductEntity())
            }
            refreshFavoriteList()
        }
    }

    fun loadCatalogList() {
        viewModelScope.launch {
            networkUnionUseCases.getCatalogList.invoke().onStart {
                catalogList.value = Resource.Loading()
            }.catch {
                catalogList.value = Resource.Error(it.message!!)
            }.collect {
                catalogList.value = Resource.Success(it.items)
            }
        }
    }

    fun checkProductForFavoriteStatus(catalogItem: Item): Boolean {
        return when (favoriteList.contains(catalogItem.toProductEntity())) {
            true -> true
            false -> false
        }
    }

    fun refreshFavoriteList() {
        viewModelScope.launch {
            favoriteList = roomRepository.selectAllFavoritesItems()
        }
    }

    fun openProductPage(product: Item) {
        selectedItem = product
        itemSelectedStatus = true
    }

    fun closeProductPage() {
        itemSelectedStatus = false
        selectedItem = null
    }
}