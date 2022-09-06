package dev.efremovkirill.foodmarket.domain.model

data class Order(
    var id: String,
    var totalPrice: Float,
    var foodList: List<FoodModel>
)