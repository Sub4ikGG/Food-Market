package dev.efremovkirill.foodmarket.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.data.di.App
import dev.efremovkirill.foodmarket.domain.usecase.GetOrdersHistoryUseCase
import dev.efremovkirill.foodmarket.presentation.recyclerview.OrdersHistoryAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrdersHistoryFragment : Fragment() {

    private val ordersHistoryAdapter = OrdersHistoryAdapter()
    private val getOrdersHistory = GetOrdersHistoryUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.apply {
            inject(ordersHistoryAdapter)
            inject(getOrdersHistory)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ordersHistoryRcView = setupRcView(view)
        getOrdersHistory(ordersHistoryRcView)
    }

    private fun setupRcView(view: View): RecyclerView {
        val ordersHistoryRcView = view.findViewById<RecyclerView>(R.id.orders_history_rcView)
        ordersHistoryRcView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        ordersHistoryRcView.adapter = ordersHistoryAdapter
        return ordersHistoryRcView
    }

    private fun getOrdersHistory(ordersHistoryRcView: RecyclerView) {
        CoroutineScope(Dispatchers.IO).launch {

            val history = getOrdersHistory.execute()
            launch(Dispatchers.Main) {
                ordersHistoryRcView.animate().apply {
                    duration = 300
                    alpha(0f)
                }.withEndAction {
                    ordersHistoryAdapter.put(history)
                    ordersHistoryRcView.animate().apply {
                        duration = 300
                        alpha(1f)
                    }
                }
            }

        }
    }

}