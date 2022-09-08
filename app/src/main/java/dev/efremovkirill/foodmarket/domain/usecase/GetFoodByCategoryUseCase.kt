package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository
import javax.inject.Inject

class GetFoodByCategoryUseCase {

    @Inject
    lateinit var repository: MenuRepository

    suspend fun execute(category: CategoryModel): List<FoodModel> {
        return repository.getFoodByCategory(category)
    }
}