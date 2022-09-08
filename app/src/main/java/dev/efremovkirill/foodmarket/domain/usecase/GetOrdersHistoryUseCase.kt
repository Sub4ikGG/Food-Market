package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.OrderModel
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository
import javax.inject.Inject

class GetOrdersHistoryUseCase {

    @Inject
    lateinit var repository: OrdersRepository

    suspend fun execute(): List<OrderModel> {
        return repository.getOrdersHistory()
    }
}