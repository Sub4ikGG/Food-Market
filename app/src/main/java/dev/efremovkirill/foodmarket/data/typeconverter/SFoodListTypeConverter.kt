package dev.efremovkirill.foodmarket.data.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.efremovkirill.foodmarket.data.model.SFoodModel
import java.util.*

class SFoodListTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun listToString(someObjects: List<SFoodModel>): String {
        return gson.toJson(someObjects)
    }

    @TypeConverter
    fun stringToList(data: String?): List<SFoodModel> {
        if(data == null) return Collections.emptyList()

        val listType = object : TypeToken<List<SFoodModel>>() { }.type
        return gson.fromJson(data, listType)
    }
}