package com.tematihonov.effectivemobiletest.presentation.catalog

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tematihonov.effectivemobiletest.domain.models.Item
import com.tematihonov.effectivemobiletest.domain.usecase.NetworkUnionUseCases
import com.tematihonov.effectivemobiletest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val networkUnionUseCases: NetworkUnionUseCases
): ViewModel() {

    val catalogList: MutableState<Resource<List<Item>>> = mutableStateOf(Resource.Loading())

    var selectedItem: Item? by mutableStateOf(null)
    var itemSelectedStatus by mutableStateOf(false)


    fun loadCatalogList() {
        viewModelScope.launch {
            networkUnionUseCases.getCatalogList.invoke().onStart {
                catalogList.value = Resource.Loading()
                Log.d("GGG", "loading")
            }.catch {
                catalogList.value = Resource.Error(it.message!!)
                Log.d("GGG", "error ${it.message}")
            }.collect {
                catalogList.value = Resource.Success(it.items)
                Log.d("GGG", "success")
            }
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