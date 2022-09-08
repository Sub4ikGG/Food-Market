package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.storage.menu.MenuStorage
import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository

class MenuRepositoryImpl(val menuStorage: MenuStorage): MenuRepository {
    override suspend fun getFoodCategories(): List<CategoryModel> {
        return menuStorage.getFoodCategories()
    }

    override suspend fun getFoodByCategory(category: CategoryModel): List<FoodModel> {
        return menuStorage.getFoodByCategory(category)
    }

    override suspend fun getFoodById(id: String): FoodModel {
        return menuStorage.getFoodById(id)
    }
}