package dev.efremovkirill.foodmarket.data.storage.orders

import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel
import dev.efremovkirill.foodmarket.data.storage.room.dao.OrdersDao
import dev.efremovkirill.foodmarket.data.storage.room.repository.OrdersRoomRepository
import javax.inject.Inject

class OrdersStorageImpl @Inject constructor(var ordersRoomRepository: OrdersRoomRepository): OrdersStorage {

    override suspend fun send(order: SOrderModel) {
        // Send to Restaurant system
    }

    override suspend fun save(order: SOrderModel) {
        ordersRoomRepository.insertOrderInDatabase(order)
    }

    override suspend fun getOrdersHistory(): List<SOrderModel> {
        return ordersRoomRepository.getOrders()
    }

    override suspend fun addFoodToCart(food: SFoodModel) {
        ordersRoomRepository.addFoodInCart(food)
    }

    override suspend fun removeFoodFromCart(food: SFoodModel) {
        ordersRoomRepository.removeFoodFromCart(food)
    }

    override suspend fun getCart(): List<SFoodModel> {
        return ordersRoomRepository.getCart()
    }

}