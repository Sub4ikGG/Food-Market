package dev.efremovkirill.foodmarket.presentation.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.model.OrderModel
import javax.inject.Inject

class FoodRowAdapter: RecyclerView.Adapter<FoodRowAdapter.FoodRowViewHolder>() {
    private var food = listOf<FoodModel>()

    @Inject
    lateinit var context: Context

    inner class FoodRowViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(foodModel: FoodModel) {
            val nameTextView = view.findViewById<TextView>(R.id.row_name_textView)
            val priceTextView = view.findViewById<TextView>(R.id.row_price_textView)

            val name = "• ${foodModel.name}"
            val price = "$${foodModel.price}"

            nameTextView.text = name
            priceTextView.text = price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodRowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.order_food_item, parent, false)
        return FoodRowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodRowViewHolder, position: Int) {
        holder.bind(food[position])
    }

    override fun getItemCount(): Int {
        return food.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun put(list: List<FoodModel>) {
        food = list
        notifyDataSetChanged()
    }
}