package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel

interface MenuStorage {

    suspend fun getFoodCategories(): List<Category>

    suspend fun getFoodByCategory(category: Category): List<FoodModel>

    suspend fun getFoodById(id: String): FoodModel

}