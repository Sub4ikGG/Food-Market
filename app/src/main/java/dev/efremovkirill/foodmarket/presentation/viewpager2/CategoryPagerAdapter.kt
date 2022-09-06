package dev.efremovkirill.foodmarket.presentation.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

const val IMAGE_PARAM = "image_param"

class CategoryPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private var categoryUrlList = emptyList<String>()

    override fun getItemCount(): Int {
        return categoryUrlList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = CategoryFragment()
        fragment.arguments = Bundle().apply {
            putString(IMAGE_PARAM, categoryUrlList[position])
        }
        return fragment
    }

    fun put(urlList: List<String>) {
        categoryUrlList = urlList
    }
}