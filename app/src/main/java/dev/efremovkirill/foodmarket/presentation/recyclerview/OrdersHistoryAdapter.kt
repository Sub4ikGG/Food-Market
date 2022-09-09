package dev.efremovkirill.foodmarket.presentation.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.domain.model.OrderModel
import org.w3c.dom.Text
import javax.inject.Inject

class OrdersHistoryAdapter : RecyclerView.Adapter<OrdersHistoryAdapter.OrdersViewHolder>() {
    private var orders = listOf<OrderModel>()

    @Inject
    lateinit var context: Context

    inner class OrdersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(orderModel: OrderModel) {
            println(orderModel)
            val foodRowAdapter = FoodRowAdapter()

            val orderIdTextView = view.findViewById<TextView>(R.id.order_id_textView)
            val orderPriceTextView = view.findViewById<TextView>(R.id.order_price_textView)
            val orderRcView = view.findViewById<RecyclerView>(R.id.order_rcView)
            val addressTextView = view.findViewById<TextView>(R.id.address_textView)

            val id = "ORDER #${orderModel.id}"
            val price = "$${String.format("%.2f", orderModel.totalPrice + 25.99f)}"
            val address = "ADDRESS: ${orderModel.address}"

            orderIdTextView.text = id
            orderPriceTextView.text = price
            addressTextView.text = address

            applyRcView(foodRowAdapter, orderModel, orderRcView)
        }

        private fun applyRcView(
            foodRowAdapter: FoodRowAdapter,
            orderModel: OrderModel,
            orderRcView: RecyclerView
        ) {
            foodRowAdapter.put(orderModel.foodList)

            orderRcView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            orderRcView.adapter = foodRowAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.history_order_item, parent, false)
        return OrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun put(list: List<OrderModel>) {
        orders = list
        notifyDataSetChanged()
    }
}