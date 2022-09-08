package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel

interface MenuStorage {

    suspend fun getFoodCategories(): List<CategoryModel>

    suspend fun getFoodByCategory(category: CategoryModel): List<FoodModel>

    suspend fun getFoodById(id: String): FoodModel

}