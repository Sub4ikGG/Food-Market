package dev.efremovkirill.foodmarket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dev.efremovkirill.foodmarket.recyclerview.FoodAdapter
import dev.efremovkirill.foodmarket.viewpager2.CategoryPagerAdapter

class MenuFragment : Fragment() {

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]

        val foodAdapter = FoodAdapter()
        val categoryAdapter = CategoryPagerAdapter(requireActivity())
        val categoryViewPager = view.findViewById<ViewPager2>(R.id.category_viewPager2)
        val foodRcView = view.findViewById<RecyclerView>(R.id.food_rcView)

        categoryAdapter.put(listOf("Pizza", "Burgers", "Salads", "Drinks", "Sauces", "Merch"))
        foodAdapter.put(listOf("", "", "", "", "", "", "", "", "", "", ""))
        categoryViewPager.apply {
            adapter = categoryAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        foodRcView.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {
        fun newInstance() = MenuFragment()
    }
}