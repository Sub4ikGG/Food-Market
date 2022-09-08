package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.OrderModel
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository
import javax.inject.Inject

class SaveOrderUseCase {

    @Inject
    lateinit var repository: OrdersRepository

    suspend fun execute(order: OrderModel) {
        repository.saveOrder(order)
    }
}