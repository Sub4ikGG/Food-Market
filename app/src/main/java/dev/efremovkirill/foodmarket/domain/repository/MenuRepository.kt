package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel

interface MenuRepository {

    suspend fun getFoodCategories(): List<Category>

    suspend fun getFoodByCategory(category: Category): List<FoodModel>

    suspend fun getFoodById(id: String): FoodModel
}