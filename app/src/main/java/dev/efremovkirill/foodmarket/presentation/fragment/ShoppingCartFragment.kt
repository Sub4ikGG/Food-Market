package dev.efremovkirill.foodmarket.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.presentation.viewmodel.ShoppingCartViewModel

class ShoppingCartFragment : Fragment() {

    companion object {
        fun newInstance() = ShoppingCartFragment()
    }

    private lateinit var viewModel: ShoppingCartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoppingCartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}