package dev.efremovkirill.foodmarket.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.OrderModel
import dev.efremovkirill.foodmarket.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ShoppingCartViewModel : ViewModel() {

    @Inject
    lateinit var getCart: GetCartUseCase
    @Inject
    lateinit var addFoodToCartUseCase: AddFoodToCartUseCase
    @Inject
    lateinit var removeFoodFromCartUseCase: RemoveFoodFromCartUseCase
    @Inject
    lateinit var saveOrder: SaveOrderUseCase

    private val _cartListStateFlow = MutableStateFlow<List<FoodModel>>(emptyList())
    val cartListStateFlow: StateFlow<List<FoodModel>> = _cartListStateFlow.asStateFlow()

    suspend fun getCart() {
        _cartListStateFlow.emit(getCart.execute())
    }

    suspend fun addFoodToCart(food: FoodModel) {
        addFoodToCartUseCase.execute(food)
    }

    suspend fun removeFoodFromCart(food: FoodModel) {
        removeFoodFromCartUseCase.execute(food)
    }

    suspend fun saveOrder(order: OrderModel) {
        saveOrder.execute(order)
    }
}