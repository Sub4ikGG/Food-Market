package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository

class GetFoodCategoriesUseCase {

    lateinit var repository: MenuRepository

    suspend fun execute(): List<Category> {
        return repository.getFoodCategories()
    }
}