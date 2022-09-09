package dev.efremovkirill.foodmarket.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.data.animateClick
import dev.efremovkirill.foodmarket.data.di.App
import dev.efremovkirill.foodmarket.data.openFoodBottomSheet
import dev.efremovkirill.foodmarket.domain.model.CategoryModel
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.presentation.recyclerview.FoodAdapter
import dev.efremovkirill.foodmarket.presentation.viewmodel.MenuViewModel
import dev.efremovkirill.foodmarket.presentation.viewpager2.CategoryPagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MenuFragment : Fragment(), FoodAdapter.OnFoodSelectedListener {

    private lateinit var viewModel: MenuViewModel

    private val scope = CoroutineScope(Dispatchers.IO)

    private var foodAdapter = FoodAdapter(this)
    private lateinit var categoryAdapter: CategoryPagerAdapter
    private lateinit var categoryViewPager: ViewPager2
    private lateinit var foodRcView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MenuViewModel::class.java]

        (requireActivity().applicationContext as App).appComponent.apply {
            inject(viewModel)
            inject(viewModel.getFoodByCategoryUseCase)
            inject(viewModel.getFoodCategoriesUseCase)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter = CategoryPagerAdapter(requireActivity())
        categoryViewPager = view.findViewById(R.id.category_viewPager2)
        foodRcView = view.findViewById(R.id.food_rcView)

        applyMenuContent()
        applyStateFlows()
        setupClickListener(view)
    }

    private fun setupClickListener(view: View) {
        val swipeImageView: ImageView = view.findViewById(R.id.swipe_imageView)
        swipeImageView.setOnClickListener {
            swipeImageView.animateClick { categoryViewPager.currentItem++ }
        }
    }

    private fun applyMenuContent() {
        categoryViewPager.apply {
            adapter = categoryAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        foodRcView.apply {
            adapter = foodAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun applyStateFlows() {
        lifecycleScope.launchWhenStarted {
            viewModel.foodCategoriesStateFlow
                .onEach { categories ->
                    categoryAdapter.put(categories)
                }
                .collect()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.foodListStateFlow
                .onEach { foodList ->
                    val currentCategory = if (foodList.isNotEmpty()) categoryAdapter.getList()[categoryViewPager.currentItem] else CategoryModel(
                        "-",
                        ""
                    )
                    val tempCategory = if (foodList.isNotEmpty()) foodList[0].category else CategoryModel(
                        "",
                        ""
                    )

                    if (tempCategory.name != currentCategory.name) {
                        val itemId = categoryAdapter.getList().indexOf(tempCategory)
                        categoryAdapter = CategoryPagerAdapter(requireActivity())
                        viewModel.foodCategoriesStateFlow.value.let { categoryAdapter.put(it) }
                        categoryViewPager.adapter = categoryAdapter
                        categoryViewPager.setCurrentItem(itemId, false)
                    }

                    foodRcView.animate().apply {
                        duration = 300
                        alpha(0f)
                    }.withEndAction {
                        foodAdapter.put(foodList)
                        foodRcView.animate().apply {
                            duration = 300
                            alpha(1f)
                        }
                    }
                }
                .collect()
        }
    }

    override fun onResume() {
        super.onResume()

        viewPaperRegisterCallback()

    }

    private fun viewPaperRegisterCallback() {
        categoryViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                scope.launch {
                    val category = categoryAdapter.getList()[position]
                    viewModel.getFoodByCategory(category)
                }

            }
        })
    }

    override fun onFoodSelected(food: FoodModel) {
        openFoodBottomSheet(food, parentFragmentManager, null)
    }
}