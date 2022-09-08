package dev.efremovkirill.foodmarket.di

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
    fun provideEditShoppingCartUseCase(): EditShoppingCartUseCase {
        return EditShoppingCartUseCase()
    }

    @Provides
    fun provideSaveOrderUseCase(): SaveOrderUseCase {
        return SaveOrderUseCase()
    }
}