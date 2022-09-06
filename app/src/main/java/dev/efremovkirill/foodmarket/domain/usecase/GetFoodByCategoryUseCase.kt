package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository

class GetFoodByCategoryUseCase {

    lateinit var repository: MenuRepository

    suspend fun execute(category: Category): List<FoodModel> {
        return repository.getFoodByCategory(category)
    }
}