package dev.efremovkirill.foodmarket.presentation.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.data.storage.menu.MenuService
import dev.efremovkirill.foodmarket.data.storage.menu.retrofit.LoremRepository
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodAdapter(private val onFoodSelected: OnFoodSelectedListener): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var food = listOf<FoodModel>()
    private val loremRepo = LoremRepository()

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(food: FoodModel) {
            val name: TextView = view.findViewById(R.id.food_name_textView)
            val previewDesc: TextView = view.findViewById(R.id.food_previewdesc_textView)
            val price: TextView = view.findViewById(R.id.food_price_textView)
            val food_imageView: ImageView = view.findViewById(R.id.food_imageView)

            previewDesc.text = ""
            name.text = food.name
            CoroutineScope(Dispatchers.IO).launch {
                val previewLorem = MenuService.previewLorem
                val fullLorem = MenuService.fullLorem

                if(previewLorem.isEmpty() || fullLorem.isEmpty()) {
                    MenuService.previewLorem = loremRepo.getLorem(15).body().toString()
                    MenuService.fullLorem = loremRepo.getLorem(30).body().toString()
                }
                launch(Dispatchers.Main) {
                    previewDesc.text = MenuService.previewLorem
                    food.fullDesc = MenuService.fullLorem
                    price.text = "$${food.price}"
                }
            }

            food_imageView.setOnClickListener {
                onFoodSelected.onFoodSelected(food)
            }
55
            Glide
                .with(view)
                .load(food.imageUrl)
                .dontAnimate()
                .into(food_imageView)
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