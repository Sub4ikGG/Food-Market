package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.storage.user.UserStorage
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.Order
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository

class OrdersRepositoryImpl(userStorage: UserStorage): OrdersRepository {
    override suspend fun sendOrder(order: Order) {
        TODO("Not yet implemented")
    }

    override suspend fun saveOrder(order: Order) {
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