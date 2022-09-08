package dev.efremovkirill.foodmarket.data.storage.orders

import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel

interface OrdersStorage {

    suspend fun send(order: SOrderModel)

    suspend fun save(order: SOrderModel)

    suspend fun getOrdersHistory(): List<SOrderModel>

    suspend fun addFoodToCart(food: SFoodModel)

    suspend fun removeFoodFromCart(food: SFoodModel)

    suspend fun getCart(): List<SFoodModel>
}