package dev.efremovkirill.foodmarket.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {

    private val _foodListStateFlow = MutableStateFlow<List<FoodModel>>(emptyList())
    val foodListStateFlow: StateFlow<List<FoodModel>> = _foodListStateFlow.asStateFlow()

    suspend fun putFoodList(list: List<FoodModel>) = withContext(Dispatchers.IO) {
        _foodListStateFlow.emit(list)
    }
}