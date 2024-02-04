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
    private val roomRepository: RoomRepository,
) : ViewModel() {

    val catalogList: MutableState<Resource<List<Item>>> = mutableStateOf(Resource.Loading())
    private var favoriteList by mutableStateOf(emptyList<ProductEntity>())

    var selectedSort by mutableStateOf("По популярности")

    var selectedTag by mutableStateOf("Смотреть все")

    var selectedItem: Item? by mutableStateOf(null)
    var itemSelectedStatus by mutableStateOf(false)

    init {
        refreshFavoriteList()
    }

    fun sortCatalog(newSelectedSort: String) {
        selectedSort = newSelectedSort
        loadCatalogList()
    }

    fun filterCatalogByTag(newSelectedTag: String) {
        selectedTag = newSelectedTag
        loadCatalogList()
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
        val filterTag = when (selectedTag) {
            "Лицо" -> "face"
            "Тело" -> "body"
            "Загар" -> "suntan"
            "Маски" -> "mask"
            else -> ""
        }
        val sortTag = when (selectedSort) {
            "По увеличению" -> 2
            "По уменьшению" -> 3
            else -> 1
        }
        viewModelScope.launch {
            networkUnionUseCases.getCatalogList.invoke().onStart {
                catalogList.value = Resource.Loading()
            }.catch {
                catalogList.value = Resource.Error(it.message!!)
            }.collect {
                var newList = arrayListOf<Item>()
                it.items.forEach { item ->
                    when (filterTag.isNotEmpty()) {
                        true -> if (item.tags.contains(filterTag)) newList.add(item)
                        false -> newList.add(item)
                    }

                }
                when (sortTag) {
                    2 -> newList.sortBy { it.price.priceWithDiscount.toInt() }
                    3 -> newList.sortByDescending { it.price.priceWithDiscount.toInt() }
                    else -> newList.sortByDescending { it.feedback.rating }
                }
                catalogList.value = Resource.Success(newList.toList())
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