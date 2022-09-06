package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.storage.menu.MenuStorage
import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository

class MenuRepositoryImpl(menuStorage: MenuStorage): MenuRepository {
    override suspend fun getFoodCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodByCategory(category: Category): List<FoodModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodById(id: String): FoodModel {
        TODO("Not yet implemented")
    }
}