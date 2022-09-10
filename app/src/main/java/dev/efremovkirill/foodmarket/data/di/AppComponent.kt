package dev.efremovkirill.foodmarket.data.di

import dagger.Component
import dev.efremovkirill.foodmarket.domain.usecase.*
import dev.efremovkirill.foodmarket.presentation.fragment.FoodMarketFragment
import dev.efremovkirill.foodmarket.presentation.fragment.MenuFragment
import dev.efremovkirill.foodmarket.presentation.recyclerview.OrdersHistoryAdapter
import dev.efremovkirill.foodmarket.presentation.viewmodel.MenuViewModel
import dev.efremovkirill.foodmarket.presentation.viewmodel.ShoppingCartViewModel

@Component(modules = [AppModule::class, DatabaseModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(foodMarketFragment: FoodMarketFragment)
    fun inject(menuFragment: MenuFragment)
    fun inject(foodByCategoryUseCase: GetFoodByCategoryUseCase)
    fun inject(foodCategoriesUseCase: GetFoodCategoriesUseCase)
    fun inject(signUpUserByPhoneNumber: SignUpUserByPhoneNumberUseCase)
    fun inject(logInUserByPhoneNumber: LogInUserByPhoneNumberUseCase)
    fun inject(cart: GetCartUseCase)
    fun inject(addFoodToCartUseCase: AddFoodToCartUseCase)
    fun inject(removeFoodFromCartUseCase: RemoveFoodFromCartUseCase)
    fun inject(ordersHistoryAdapter: OrdersHistoryAdapter)
    fun inject(ordersHistory: GetOrdersHistoryUseCase)
    fun inject(saveOrder: SaveOrderUseCase)
    fun inject(viewModel: MenuViewModel)
    fun inject(viewModel: ShoppingCartViewModel)
}