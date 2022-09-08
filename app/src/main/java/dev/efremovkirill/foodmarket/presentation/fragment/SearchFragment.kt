package dev.efremovkirill.foodmarket.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.di.App
import dev.efremovkirill.foodmarket.domain.model.FoodModel
import dev.efremovkirill.foodmarket.domain.usecase.GetFoodByCategoryUseCase
import dev.efremovkirill.foodmarket.domain.usecase.GetFoodCategoriesUseCase
import dev.efremovkirill.foodmarket.openFoodBottomSheet
import dev.efremovkirill.foodmarket.presentation.bottomsheet.FoodBottomSheet
import dev.efremovkirill.foodmarket.presentation.recyclerview.FoodAdapter
import dev.efremovkirill.foodmarket.presentation.viewmodel.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchFragment : Fragment(), SearchView.OnQueryTextListener, FoodAdapter.OnFoodSelectedListener {

    private lateinit var viewModel: SearchViewModel

    private val getFoodByCategoryUseCase = GetFoodByCategoryUseCase()
    private val getFoodCategoriesUseCase = GetFoodCategoriesUseCase()

    private val foodAdapter = FoodAdapter(this)
    private val foodList = mutableListOf<FoodModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(getFoodByCategoryUseCase)
        (requireActivity().applicationContext as App).appComponent.inject(getFoodCategoriesUseCase)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        lifecycleScope.launchWhenStarted {
            viewModel.foodListStateFlow
                .onEach { foodList ->
                    foodAdapter.put(foodList)
                }
                .collect()
        }
        getFoodList()
        applySearchContElements(view)
    }

    private fun applySearchContElements(view: View) {
        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val searchRcView = view.findViewById<RecyclerView>(R.id.search_rcView)

        searchView.setOnQueryTextListener(this)
        searchRcView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        searchRcView.adapter = foodAdapter
    }

    private fun getFoodList() {
        CoroutineScope(Dispatchers.IO).launch {
            val categories = getFoodCategoriesUseCase.execute()

            categories.forEach { category ->
                foodList.addAll(getFoodByCategoryUseCase.execute(category))
            }

            viewModel.putFoodList(foodList)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null && query.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.putFoodList(foodList.filter { it.name.lowercase().contains(query.lowercase()) })
            }
            return true
        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.putFoodList(emptyList())
        }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText != null && newText.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.putFoodList(foodList.filter { it.name.lowercase().contains(newText.lowercase()) })
            }
            return true
        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.putFoodList(emptyList())
        }
        return false
    }

    override fun onFoodSelected(food: FoodModel) {
        openFoodBottomSheet(food, parentFragmentManager, null)
    }
}