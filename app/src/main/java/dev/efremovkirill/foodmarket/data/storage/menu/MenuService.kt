package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel

object MenuService {

    val categories = listOf(
        CategoryModel("Pizza", ""),
        CategoryModel("Burgers", ""),
        CategoryModel("Salads", ""),
        CategoryModel("Drinks", ""),
        CategoryModel("Sushi", ""),
    )

    val menu = listOf(
        FoodModel(
            0,
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
        ),
        FoodModel(
            0,
            "P2",
            "Pizza ",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[0],
            199.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "P3",
            "Pizza '4 cheeses'",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[0],
            259.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "P4",
            "Pizza Country",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[0],
            99.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "P5",
            "Pizza Chicken-Ranch",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[0],
            139.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B1",
            "Chicken Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[1],
            59.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B1",
            "Beef Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[1],
            69.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B1",
            "Big Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[1],
            109.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B1",
            "Cringe Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "",
            categories[1],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
    )

}