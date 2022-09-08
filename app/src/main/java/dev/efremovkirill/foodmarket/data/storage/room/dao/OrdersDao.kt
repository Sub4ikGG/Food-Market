package dev.efremovkirill.foodmarket.data.storage.room.dao

import androidx.room.*
import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrderInDatabase(order: SOrderModel)

    @Query("SELECT * FROM orders_table")
    suspend fun getOrders(): List<SOrderModel>

    @Insert
    suspend fun addFoodInCart(food: SFoodModel)

    @Delete
    suspend fun removeFoodFromCart(food: SFoodModel)

    @Query("SELECT * FROM cart_table")
    suspend fun getCart(): List<SFoodModel>
}