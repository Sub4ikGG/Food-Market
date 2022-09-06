package dev.efremovkirill.foodmarket.data.model

data class SFoodModel(
    var id: String,
    var name: String,
    var previewDesc: String,
    var fullDesc: String,
    var imageUrl: String,
    var category: SCategory,
    var price: Float,
    var calories: Int,
    var weight: Float,
    var dough: String,
    var preparingTime: String
)