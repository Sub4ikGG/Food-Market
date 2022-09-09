package dev.efremovkirill.foodmarket.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dev.efremovkirill.foodmarket.databinding.FragmentFoodmarketBinding


class FoodMarketFragment : Fragment() {

    private lateinit var binding: FragmentFoodmarketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodmarketBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        applyBottomNav()
    }

    private fun applyBottomNav() {
        val navController = binding.mainNavHostFragment.findNavController()
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }
}