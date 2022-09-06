package dev.efremovkirill.foodmarket.data.storage.orders

import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.Order

class OrdersStorageImpl: OrdersStorage {

    override suspend fun send(order: Order) {
        TODO("Not yet implemented")
    }

    override suspend fun save(order: Order) {
        TODO("Not yet implemented")
    }

    override suspend fun getOrdersHistory(): List<Order> {
        TODO("Not yet implemented")
    }

    override suspend fun addFoodToCart(food: FoodModel) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFoodFromCart(food: FoodModel) {
        TODO("Not yet implemented")
    }

}