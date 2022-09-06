package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.Order

interface OrdersRepository {

    suspend fun sendOrder(order: Order)

    suspend fun saveOrder(order: Order)

    suspend fun getOrdersHistory(): List<Order>

    suspend fun addFoodToCart(food: FoodModel)

    suspend fun removeFoodFromCart(food: FoodModel)
}