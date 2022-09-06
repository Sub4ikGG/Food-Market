package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel

class MenuStorageImpl: MenuStorage {

    override suspend fun getFoodCategories(): List<Category> {
        return MenuService.categories
    }

    override suspend fun getFoodByCategory(category: Category): List<FoodModel> {
        return MenuService.menu.filter { it.category == category }
    }

    override suspend fun getFoodById(id: String): FoodModel {
        return MenuService.menu.filter { it.id == id }[0]
    }
}