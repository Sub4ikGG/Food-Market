package dev.efremovkirill.foodmarket.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.efremovkirill.foodmarket.data.DEBUG_MODE
import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.usecase.GetFoodByCategoryUseCase
import dev.efremovkirill.foodmarket.domain.usecase.GetFoodCategoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuViewModel : ViewModel() {

    @Inject lateinit var getFoodByCategoryUseCase: GetFoodByCategoryUseCase
    @Inject lateinit var getFoodCategoriesUseCase: GetFoodCategoriesUseCase

    private val _foodCategoriesStateFlow = MutableStateFlow<List<CategoryModel>>(emptyList())
    val foodCategoriesStateFlow: StateFlow<List<CategoryModel>> = _foodCategoriesStateFlow.asStateFlow()

    private val _foodListStateFlow = MutableStateFlow<List<FoodModel>>(emptyList())
    val foodListStateFlow: StateFlow<List<FoodModel>> = _foodListStateFlow.asStateFlow()

    init {
        Log.d(DEBUG_MODE, "MenuViewModel initialized.")

        viewModelScope.launch {
            while(!this@MenuViewModel::getFoodCategoriesUseCase.isInitialized) delay(100)
            getFoodCategories()
        }
    }

    suspend fun getFoodCategories() = withContext(Dispatchers.IO) {
        _foodCategoriesStateFlow.emit(getFoodCategoriesUseCase.execute())
    }

    suspend fun getFoodByCategory(category: CategoryModel) = withContext(Dispatchers.IO) {
        _foodListStateFlow.emit(getFoodByCategoryUseCase.execute(category))
    }
}