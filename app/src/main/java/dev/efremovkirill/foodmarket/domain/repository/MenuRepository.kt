package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel

interface MenuRepository {

    suspend fun getFoodCategories(): List<CategoryModel>

    suspend fun getFoodByCategory(category: CategoryModel): List<FoodModel>

    suspend fun getFoodById(id: String): FoodModel
}