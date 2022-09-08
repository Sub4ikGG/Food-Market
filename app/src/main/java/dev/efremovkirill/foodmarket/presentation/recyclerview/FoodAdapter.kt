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

class FoodAdapter(private val onFoodSelected: OnFoodSelectedListener): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var food = listOf<FoodModel>()

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(food: FoodModel) {
            val name: TextView = view.findViewById(R.id.food_name_textView)
            val previewDesc: TextView = view.findViewById(R.id.food_previewdesc_textView)
            val price: TextView = view.findViewById(R.id.food_price_textView)
            val food_imageView: ImageView = view.findViewById(R.id.food_imageView)

            name.text = food.name
            previewDesc.text = food.previewDesc
            price.text = "$${food.price}"

            food_imageView.setOnClickListener {
                onFoodSelected.onFoodSelected(food)
            }
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
    fun put(food: List<FoodModel>) {
        this.food = food
        notifyDataSetChanged()
    }

    interface OnFoodSelectedListener {
        fun onFoodSelected(food: FoodModel)
    }
}