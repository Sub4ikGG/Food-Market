package dev.efremovkirill.foodmarket.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import dev.efremovkirill.foodmarket.data.typeconverter.SFoodListTypeConverter

@Entity(tableName = "orders_table")
data class SOrderModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var totalPrice: Float,
    @TypeConverters(SFoodListTypeConverter::class)
    @SerializedName("food_list") var foodList: List<SFoodModel> = listOf(),
    var address: String = ""
)