package dev.efremovkirill.foodmarket.presentation.fragment

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.*
import dev.efremovkirill.foodmarket.data.*
import dev.efremovkirill.foodmarket.data.di.App
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.OrderModel
import dev.efremovkirill.foodmarket.presentation.recyclerview.FoodAdapter
import dev.efremovkirill.foodmarket.presentation.recyclerview.FoodCartAdapter
import dev.efremovkirill.foodmarket.presentation.viewmodel.ShoppingCartViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ShoppingCartFragment : Fragment(), FoodAdapter.OnFoodSelectedListener, FoodCartAdapter.OnFoodRemoveListener,
    OnFoodAddedFromBottomSheet {

    private val foodCartAdapter = FoodCartAdapter(this, this)

    private lateinit var viewModel: ShoppingCartViewModel
    private lateinit var checkoutLayout: ConstraintLayout
    private lateinit var paymentForFood: TextView
    private lateinit var deliveryPrice: TextView
    private lateinit var totalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ShoppingCartViewModel::class.java]

        (requireActivity().applicationContext as App).appComponent.apply {
            inject(viewModel)
            inject(viewModel.saveOrder)
            inject(viewModel.addFoodToCartUseCase)
            inject(viewModel.removeFoodFromCartUseCase)
            inject(viewModel.getCart)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartRcView = view.findViewById<RecyclerView>(R.id.cart_rcView)
        val checkoutTextView = view.findViewById<TextView>(R.id.checkout_button)
        val checkoutArrowImageView = view.findViewById<ImageView>(R.id.checkout_arrow_imageView)

        checkoutLayout = view.findViewById(R.id.checkout_layout)
        paymentForFood = view.findViewById(R.id.price_textView)
        deliveryPrice = view.findViewById(R.id.delivery_price_textView)
        totalPrice = view.findViewById(R.id.total_price_textView)

        cartRcView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cartRcView.adapter = foodCartAdapter

        applyStateFlow()
        setupClickListeners(checkoutTextView, checkoutArrowImageView)
    }

    private fun applyStateFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.getCart()
            viewModel.cartListStateFlow
                .onEach { foodList ->
                    foodCartAdapter.put(foodList)
                    calculateOrder()
                }
                .collect()
        }
    }

    private fun setupClickListeners(checkoutTextView: TextView, checkoutArrowImageView: ImageView) {
        checkoutTextView.setOnClickListener {
            checkoutArrowImageView.slideRight {

                val cartPrice = foodCartAdapter.getCartPrice()
                if (cartPrice > 1f) {
                    val cart = foodCartAdapter.getCart()
                    val order = OrderModel(0, cartPrice, cart)

                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.saveOrder(order)

                        cart.forEach { viewModel.removeFoodFromCart(it) }
                        launch(Dispatchers.Main) {
                            foodCartAdapter.clearCart()
                            checkoutLayout.hide()
                            Toast.makeText(
                                requireContext(),
                                "Order successfully confirmed!",
                                Toast.LENGTH_SHORT
                            ).show()

                            findNavController().popBackStack()
                        }
                    }

                }

            }
        }
    }

    private fun calculateOrder() {
        val cartPrice = foodCartAdapter.getCartPrice()
        if (foodCartAdapter.getCart().isNotEmpty()) {
            paymentForFood.text = "$${String.format("%.2f", cartPrice)}"
            deliveryPrice.text = "$25.99"
            totalPrice.text = "$${String.format("%.2f", cartPrice + 25.99f)}"
            checkoutLayout.show()
        }
        else {
            checkoutLayout.hide()
        }
    }

    override fun onResume() {
        super.onResume()

        calculateOrder()
    }

    override fun onFoodSelected(food: FoodModel) {
        openFoodBottomSheet(food, parentFragmentManager, this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onFoodRemove(food: FoodModel, position: Int) {
        foodCartAdapter.notifyItemRemoved(position)
        calculateOrder()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.removeFoodFromCart(food)
        }
    }

    override fun onFoodAddedFromBottomSheet() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getCart()
        }
    }
}