package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository

class EditShoppingCartUseCase {

    lateinit var repository: OrdersRepository

    suspend fun addToCart(food: FoodModel) {
        repository.addFoodToCart(food)
    }

    suspend fun removeFromCart(food: FoodModel) {
        repository.removeFoodFromCart(food)
    }
}