package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository

class GetFoodByIdUseCase {

    lateinit var repository: MenuRepository

    suspend fun execute(id: String): FoodModel {
        return repository.getFoodById(id)
    }
}