package dev.efremovkirill.foodmarket.data.di

import dagger.Module
import dagger.Provides
import dev.efremovkirill.foodmarket.domain.usecase.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetFoodCategoriesUseCase(): GetFoodCategoriesUseCase {
        return GetFoodCategoriesUseCase()
    }

    @Provides
    fun provideGetFoodByCategoryUseCase(): GetFoodByCategoryUseCase {
        return GetFoodByCategoryUseCase()
    }

    @Provides
    fun provideGetCartUseCase(): GetCartUseCase {
        return GetCartUseCase()
    }

    @Provides
    fun provideAddFoodToCartUseCase(): AddFoodToCartUseCase {
        return AddFoodToCartUseCase()
    }

    @Provides
    fun provideRemoveFoodFromCartUseCase(): RemoveFoodFromCartUseCase {
        return RemoveFoodFromCartUseCase()
    }

    @Provides
    fun provideSaveOrderUseCase(): SaveOrderUseCase {
        return SaveOrderUseCase()
    }
}