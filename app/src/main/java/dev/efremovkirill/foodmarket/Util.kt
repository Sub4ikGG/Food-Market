package dev.efremovkirill.foodmarket

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
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

fun ConstraintLayout.show() {
    this.animate().apply {
        duration = 0
        translationY(-1000f)
    }.withEndAction {
        this.animate().apply {
            duration = 500
            translationY(1000f)
        }
    }
}

fun ConstraintLayout.hide() {
    this.animate().apply {
        duration = 500
        translationY(-1000f)
    }.withEndAction {
        this.visibility = View.GONE
    }
}

fun View.slideRight(unit: () -> Unit) {
    this.animate().apply {
        duration = 300
        translationX(10000f)
    }.withEndAction(unit)
}

fun View.animateClick(unit: () -> Unit) {
    this.animate().apply {
        duration = 200
        scaleX(0.7f)
        scaleY(0.7f)
    }.withEndAction {
        this.animate().apply {
            duration = 200
            scaleX(1f)
            scaleY(1f)
        }.withEndAction(unit)
    }
}

interface OnFoodAddedFromBottomSheet {
    fun onFoodAddedFromBottomSheet()
}