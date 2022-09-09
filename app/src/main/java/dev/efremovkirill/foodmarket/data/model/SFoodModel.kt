package dev.efremovkirill.foodmarket.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.efremovkirill.foodmarket.data.typeconverter.SCategoryTypeConverter

@Entity(tableName = "cart_table")
data class SFoodModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var food_id: String,
    var name: String,
    var previewDesc: String,
    var fullDesc: String,
    var imageUrl: String,

    @TypeConverters(SCategoryTypeConverter::class)
    var category: SCategoryModel,

    var price: Float,
    var calories: Int,
    var weight: Float,
    var dough: String,
    var preparingTime: String
)