package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository
import javax.inject.Inject

class RemoveFoodFromCartUseCase {

    @Inject
    lateinit var repository: OrdersRepository

    suspend fun execute(food: FoodModel) {
        repository.removeFoodFromCart(food)
    }

}