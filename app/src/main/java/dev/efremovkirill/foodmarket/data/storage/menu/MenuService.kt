package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.Category
import dev.efremovkirill.foodmarket.domain.model.FoodModel

object MenuService {

    val categories = listOf(
        Category("Pizza", ""),
        Category("Burgers", ""),
        Category("Salads", ""),
        Category("Drinks", ""),
        Category("Sushi", ""),
    )

    val menu = listOf(
        FoodModel(
            "P1",
            "Pizza Pepperoni",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[0],
            299.99f,
            320,
            300f,
            "Thin",
            "15 min."
        )
    )

}