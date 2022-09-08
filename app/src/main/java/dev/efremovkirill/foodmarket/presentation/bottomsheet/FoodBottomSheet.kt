package dev.efremovkirill.foodmarket.presentation.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import dev.efremovkirill.foodmarket.OnFoodAddedFromBottomSheet
import dev.efremovkirill.foodmarket.databinding.FoodBottomSheetBinding
import dev.efremovkirill.foodmarket.di.App
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.usecase.EditShoppingCartUseCase
import dev.efremovkirill.foodmarket.presentation.viewmodel.ShoppingCartViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodBottomSheet(private var onFoodAddedFromBottomSheet: OnFoodAddedFromBottomSheet?): BottomSheetDialogFragment() {
    private var _binding: FoodBottomSheetBinding? = null

    private val binding get() = _binding!!

    private val editShoppingCart = EditShoppingCartUseCase()

    private lateinit var shoppingCartViewModel: ShoppingCartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shoppingCartViewModel = ViewModelProvider(this)[ShoppingCartViewModel::class.java]

        (requireActivity().applicationContext as App).appComponent.inject(shoppingCartViewModel)
        (requireActivity().applicationContext as App).appComponent.inject(shoppingCartViewModel.getCart)
        (requireActivity().applicationContext as App).appComponent.inject(shoppingCartViewModel.editShoppingCart)
        (requireActivity().applicationContext as App).appComponent.inject(shoppingCartViewModel.saveOrder)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FoodBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gson = Gson()
        val food = gson.fromJson(arguments?.getString("food_model"), FoodModel::class.java)

        binding.foodNameTextView.text = food.name
        binding.foodPriceTextView.text = "$${food.price}"
        binding.foodPreviewdescTextView.text = food.fullDesc
        binding.caloriesValueTextView.text = "${food.calories} cls."
        binding.weightValueTextView.text = "${food.weight} gr."
        binding.doughValueTextView.text = food.dough
        binding.timeValueTextView.text = food.preparingTime

        binding.addToCartCardView.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                shoppingCartViewModel.addFoodToCart(food)
                onFoodAddedFromBottomSheet?.onFoodAddedFromBottomSheet()
                launch(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Successfully added to cart!", Toast.LENGTH_SHORT).show()
                    dismiss()
                }
            }
        }
    }
}