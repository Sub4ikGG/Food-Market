package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository
import javax.inject.Inject

class GetFoodCategoriesUseCase {

    @Inject
    lateinit var repository: MenuRepository

    suspend fun execute(): List<CategoryModel> {
        return repository.getFoodCategories()
    }
}