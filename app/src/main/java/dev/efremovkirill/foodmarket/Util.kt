package dev.efremovkirill.foodmarket

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.gson.Gson
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.presentation.bottomsheet.FoodBottomSheet

const val DEBUG_MODE = "debug_mode"

fun openFoodBottomSheet(food: FoodModel, fragmentManager: FragmentManager, onFoodAddedFromBottomSheet: OnFoodAddedFromBottomSheet? = null) {
    val gson = Gson()
    val bundle = Bundle()

    val bottomSheetFood = FoodModel(
        0,
        food.foodId,
        food.name,
        food.previewDesc,
        food.fullDesc,
        food.imageUrl,
        food.category,
        food.price,
        food.calories,
        food.weight,
        food.dough,
        food.preparingTime
    )

    bundle.putString("food_model", gson.toJson(bottomSheetFood))

    val foodBottomSheet = FoodBottomSheet(onFoodAddedFromBottomSheet)
    foodBottomSheet.arguments = bundle
    foodBottomSheet.show(fragmentManager, "Food Bottom Sheet")
}

interface OnFoodAddedFromBottomSheet {
    fun onFoodAddedFromBottomSheet()
}