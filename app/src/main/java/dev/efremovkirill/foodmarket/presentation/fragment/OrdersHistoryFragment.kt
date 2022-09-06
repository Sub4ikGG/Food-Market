package dev.efremovkirill.foodmarket.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.efremovkirill.foodmarket.presentation.viewmodel.OrdersHistoryViewModel
import dev.efremovkirill.foodmarket.R

class OrdersHistoryFragment : Fragment() {

    private lateinit var viewModel: OrdersHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OrdersHistoryViewModel::class.java]
    }

    companion object {
        fun newInstance() = OrdersHistoryFragment()
    }
}