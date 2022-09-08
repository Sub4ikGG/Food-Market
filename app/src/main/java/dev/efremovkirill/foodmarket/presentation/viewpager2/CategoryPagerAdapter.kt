package dev.efremovkirill.foodmarket.presentation.viewpager2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.efremovkirill.foodmarket.domain.model.CategoryModel

const val TITLE_PARAM = "title_param"
const val IMAGE_PARAM = "image_param"

class CategoryPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private var _categoryList = emptyList<CategoryModel>()

    override fun getItemCount(): Int {
        return _categoryList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = CategoryFragment()
        fragment.arguments = Bundle().apply {
            putString(TITLE_PARAM, _categoryList[position].name)
            putString(IMAGE_PARAM, _categoryList[position].imageUrl)
        }
        return fragment
    }

    fun getList() = _categoryList

    @SuppressLint("NotifyDataSetChanged")
    fun put(list: List<CategoryModel>) {
        _categoryList = list
        notifyDataSetChanged()
    }
}