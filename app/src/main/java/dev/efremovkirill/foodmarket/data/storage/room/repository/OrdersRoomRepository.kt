package dev.efremovkirill.foodmarket.data.storage.room.repository

import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel
import dev.efremovkirill.foodmarket.data.storage.room.dao.OrdersDao

class OrdersRoomRepository(var ordersDao: OrdersDao) {

    suspend fun insertOrderInDatabase(order: SOrderModel) {
        ordersDao.insertOrderInDatabase(order)
    }

    suspend fun getOrders(): List<SOrderModel> {
        return ordersDao.getOrders()
    }

    suspend fun addFoodInCart(food: SFoodModel) {
        ordersDao.addFoodInCart(food)
    }

    suspend fun removeFoodFromCart(food: SFoodModel) {
        ordersDao.removeFoodFromCart(food)
    }

    suspend fun getCart(): List<SFoodModel> {
        return ordersDao.getCart()
    }

}