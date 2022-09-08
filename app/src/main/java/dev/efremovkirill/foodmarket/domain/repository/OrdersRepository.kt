package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.OrderModel

interface OrdersRepository {

    suspend fun sendOrder(order: OrderModel)

    suspend fun saveOrder(order: OrderModel)

    suspend fun getOrdersHistory(): List<OrderModel>

    suspend fun addFoodToCart(food: FoodModel)

    suspend fun removeFoodFromCart(food: FoodModel)

    suspend fun getCart(): List<FoodModel>
}