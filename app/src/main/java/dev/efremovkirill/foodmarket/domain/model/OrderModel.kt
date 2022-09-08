package dev.efremovkirill.foodmarket.domain.model

data class OrderModel(
    var id: Int,
    var totalPrice: Float,
    var foodList: List<FoodModel>,
    var address: String = ""
)