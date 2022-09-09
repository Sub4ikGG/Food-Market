package dev.efremovkirill.foodmarket.data.storage.menu

import dev.efremovkirill.foodmarket.data.storage.menu.retrofit.LoremRepository
import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel

object MenuService {

    val categories = listOf(
        CategoryModel("Pizza", "https://www.iwmbuzz.com/wp-content/uploads/2022/06/easy-recipe-to-prepare-pizza-in-these-simple-steps-6.jpeg"),
        CategoryModel("Burgers", "https://p4.wallpaperbetter.com/wallpaper/579/484/991/hamburger-burger-mcdonald-s-wallpaper-preview.jpg"),
        CategoryModel("Salads", "https://c0.wallpaperflare.com/preview/483/20/869/food-and-drink-hd-wallpaper-health-food-healthy-food.jpg"),
        CategoryModel("Drinks", "https://c4.wallpaperflare.com/wallpaper/845/557/161/drink-colorful-cocktail-beverage-wallpaper-preview.jpg"),
        CategoryModel("Sushi", ""),
    )

    var previewLorem = ""
    var fullLorem = ""

    val menu = listOf(
        FoodModel(
            0,
            "P1",
            "Pizza Grand-Senora",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://f.vividscreen.info/soft/8c5dc18232b51fbb258e2575651b7b3c/Pizza-with-mushrooms-and-olives-1920x1200.jpg",
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
            "Pizza Home",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://campaignme.com/wp-content/uploads/Pizza-Hut.jpg",
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
            "https://eskipaper.com/images/pizza-wallpaper-7.jpg",
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
            "https://upload.wikimedia.org/wikipedia/commons/c/c0/Pizza_with_tomatoes.jpg",
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
            "https://popmenucloud.com/rolypefq/537cb388-2e65-437c-890e-b38a8c9b5ee5.jpg",
            categories[0],
            139.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),

        FoodModel(
            0,
            "B2",
            "Chicken Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://img2.goodfon.ru/wallpaper/nbig/c/94/burger-kartofel-fri-myaso.jpg",
            categories[1],
            59.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B3",
            "Beef Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://images.unsplash.com/photo-1571091718767-18b5b1457add?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YnVyZ2Vyc3xlbnwwfHwwfHw%3D&w=1000&q=80",
            categories[1],
            69.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B4",
            "Big Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://pokerrunsamerica.com/wp-content/uploads/2014/11/fast_food_burger-wallpaper-1280x720.jpg",
            categories[1],
            109.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "B5",
            "Cringe Burger",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://look.com.ua/pic/202011/1280x720/look.com.ua-365650.jpg",
            categories[1],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),

        FoodModel(
            0,
            "S1",
            "Caesar",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://www.simplyrecipes.com/thmb/j1WtO-KNzo7D7e3j5skU2CIQGk4=/1800x1200/filters:fill(auto,1)/__opt__aboutcom__coeus__resources__content_migration__simply_recipes__uploads__2009__09__caesar-salad-horiz-a-1800-4a465eb53456465091e34138675259c2.jpg",
            categories[2],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "S2",
            "Grand-Senora",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://images.wallpaperscraft.ru/image/single/salat_pomidory_morkov_listya_111119_1280x720.jpg",
            categories[2],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "S3",
            "Saladgtable",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://assets.epicurious.com/photos/54ca916dc252103035d377ef/16:9/w_1280,c_limit/51261260_salad-with-radishes_6x4.jpg",
            categories[2],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),

        FoodModel(
            0,
            "D1",
            "Cola",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://blenderartists.org/uploads/default/original/4X/f/f/2/ff20ecec440f1ce1ca504891877aa1a3c1483326.jpg",
            categories[3],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
        FoodModel(
            0,
            "D2",
            "Water",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "Chicken, Onion, Jalapeno Pepper, Mozzarella Cheese, Tomato Sauce, Sweet Chili Sauce",
            "https://cdna.artstation.com/p/assets/images/images/003/602/974/large/prem-kumar-bottles-new-render.jpg?1475506978",
            categories[3],
            89.99f,
            320,
            300f,
            "Thin",
            "15 min."
        ),
    )

}