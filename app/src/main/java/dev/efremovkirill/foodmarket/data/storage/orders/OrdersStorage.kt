package dev.efremovkirill.foodmarket.data.storage.orders

import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.Order

interface OrdersStorage {

    suspend fun send(order: Order)

    suspend fun save(order: Order)

    suspend fun getOrdersHistory(): List<Order>

    suspend fun addFoodToCart(food: FoodModel)

    suspend fun removeFoodFromCart(food: FoodModel)
}