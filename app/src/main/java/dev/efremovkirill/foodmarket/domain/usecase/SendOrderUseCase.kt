package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.Order
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository

class SendOrderUseCase {

    lateinit var repository: OrdersRepository

    suspend fun execute(order: Order) {
        repository.sendOrder(order)
    }
}