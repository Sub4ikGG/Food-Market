package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel

class MenuStorageImpl: MenuStorage {

    override suspend fun getFoodCategories(): List<CategoryModel> {
        return MenuService.categories
    }

    override suspend fun getFoodByCategory(category: CategoryModel): List<FoodModel> {
        return MenuService.menu.filter { it.category == category }
    }

    override suspend fun getFoodById(id: String): FoodModel {
        return MenuService.menu.filter { it.foodId == id }[0]
    }
}