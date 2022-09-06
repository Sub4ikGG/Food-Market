package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.Order
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository

class GetOrdersHistoryUseCase {

    lateinit var repository: OrdersRepository

    suspend fun execute(): List<Order> {
        return repository.getOrdersHistory()
    }
}