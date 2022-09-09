package dev.efremovkirill.foodmarket.data.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.efremovkirill.foodmarket.data.model.SCategoryModel

class SCategoryTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun listToString(someObject: SCategoryModel): String {
        return gson.toJson(someObject)
    }

    @TypeConverter
    fun stringToList(data: String): SCategoryModel {
        val listType = object : TypeToken<SCategoryModel>() { }.type
        return gson.fromJson(data, listType)
    }
}