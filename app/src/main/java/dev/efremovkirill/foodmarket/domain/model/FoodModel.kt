package dev.efremovkirill.foodmarket.domain.model

data class FoodModel(
    var id: Int,
    var foodId: String,
    var name: String,
    var previewDesc: String,
    var fullDesc: String,
    var imageUrl: String,
    var category: CategoryModel,
    var price: Float,
    var calories: Int,
    var weight: Float,
    var dough: String,
    var preparingTime: String
)