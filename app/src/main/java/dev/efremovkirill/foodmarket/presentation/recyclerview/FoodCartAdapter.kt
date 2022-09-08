package dev.efremovkirill.foodmarket.presentation.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.domain.model.FoodModel

class FoodCartAdapter(private val onFoodSelected: FoodAdapter.OnFoodSelectedListener, private val onFoodRemove: OnFoodRemoveListener): RecyclerView.Adapter<FoodCartAdapter.ViewHolder>() {
    private var food = mutableListOf<FoodModel>()

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(food: FoodModel) {
            val name: TextView = view.findViewById(R.id.food_name_textView)
            val previewDesc: TextView = view.findViewById(R.id.food_previewdesc_textView)
            val price: TextView = view.findViewById(R.id.food_price_textView)
            val foodImageView: ImageView = view.findViewById(R.id.food_imageView)
            val removeFoodImageView: ImageView = view.findViewById(R.id.remove_food_imageView)

            name.text = food.name
            previewDesc.text = food.previewDesc
            price.text = "$${food.price}"

            foodImageView.setOnClickListener {
                onFoodSelected.onFoodSelected(food)
            }

            removeFoodImageView.setOnClickListener {
                this@FoodCartAdapter.food.removeAt(adapterPosition)
                onFoodRemove.onFoodRemove(food, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(food[position])
    }

    override fun getItemCount(): Int {
        return food.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearCart() {
        food.clear()
        notifyDataSetChanged()
    }

    fun getCart(): List<FoodModel> = food

    @SuppressLint("NotifyDataSetChanged")
    fun put(food: List<FoodModel>) {
        if(food.isNotEmpty())
            this.food = food as MutableList<FoodModel>
        else this.food = emptyList<FoodModel>().toMutableList()
        notifyDataSetChanged()
    }

    fun getCartPrice(): Float {
        var price = 0f

        food.forEach {
            price += it.price
        }

        return price
    }

    interface OnFoodRemoveListener {
        fun onFoodRemove(food: FoodModel, position: Int)
    }
}