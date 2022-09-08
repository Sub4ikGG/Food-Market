package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.model.SCategoryModel
import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel
import dev.efremovkirill.foodmarket.data.storage.orders.OrdersStorage
import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.OrderModel
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository

class OrdersRepositoryImpl(val ordersStorage: OrdersStorage) : OrdersRepository {
    override suspend fun sendOrder(order: OrderModel) {
        ordersStorage.send(order.toSOrder())
    }

    override suspend fun saveOrder(order: OrderModel) {
        val sOrder = order.toSOrder()
        ordersStorage.save(sOrder)

    }

    override suspend fun getOrdersHistory(): List<OrderModel> {
        val sList = ordersStorage.getOrdersHistory()

        val list = mutableListOf<OrderModel>()
        sList.forEach { sOrder ->
            list.add(sOrder.toOrder())
        }

        return list
    }

    override suspend fun addFoodToCart(food: FoodModel) {
        ordersStorage.addFoodToCart(food.toSFood())
    }

    override suspend fun removeFoodFromCart(food: FoodModel) {
        ordersStorage.removeFoodFromCart(food.toSFood())
    }

    override suspend fun getCart(): List<FoodModel> {
        val sList = ordersStorage.getCart()
        val list = mutableListOf<FoodModel>()

        sList.forEach { sFood ->
            list.add(sFood.toFood())
        }

        return list
    }

    private fun FoodModel.toSFood(): SFoodModel {
        return SFoodModel(
            this.id,
            this.foodId,
            this.name,
            this.previewDesc,
            this.fullDesc,
            this.imageUrl,
            SCategoryModel(this.category.name, this.category.imageUrl),
            this.price,
            this.calories,
            this.weight,
            this.dough,
            this.preparingTime
        )
    }

    private fun SFoodModel.toFood(): FoodModel {
        return FoodModel(
            this.id,
            this.food_id,
            this.name,
            this.previewDesc,
            this.fullDesc,
            this.imageUrl,
            CategoryModel(this.category.name, this.category.imageUrl),
            this.price,
            this.calories,
            this.weight,
            this.dough,
            this.preparingTime
        )
    }

    private fun SOrderModel.toOrder(): OrderModel {
        val foodList = mutableListOf<FoodModel>()
        this.foodList.forEach { sFood ->
            foodList.add(sFood.toFood())
        }

        return OrderModel(this.id, this.totalPrice, foodList, this.address)
    }

    private fun OrderModel.toSOrder(): SOrderModel {
        val sFoodList = mutableListOf<SFoodModel>()
        this.foodList.forEach { food ->
            sFoodList.add(
                food.toSFood()
            )
        }

        return SOrderModel(this.id, this.totalPrice, sFoodList, this.address)
    }
}