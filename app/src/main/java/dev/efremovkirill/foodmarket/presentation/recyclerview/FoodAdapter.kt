package dev.efremovkirill.foodmarket.presentation.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var food = listOf<String>()

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(product: String) {
            /*val productName: TextView = view.findViewById(R.id.product_name)
            val productPrice: TextView = view.findViewById(R.id.product_price)
            val productOldPrice: TextView = view.findViewById(R.id.product_old_price)

            productName.text = product.name
            productPrice.text = "${product.price} ₽"
            //productOldPrice.text = "${product.old_price}"*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.preview_food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(food[position])
    }

    override fun getItemCount(): Int {
        return food.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun put(food: List<String>) {
        this.food = food
        notifyDataSetChanged()
    }
}