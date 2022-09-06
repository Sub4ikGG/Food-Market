package dev.efremovkirill.foodmarket.data.model

data class SOrder(
    var id: String,
    var totalPrice: Float,
    var foodList: List<SFoodModel>
)