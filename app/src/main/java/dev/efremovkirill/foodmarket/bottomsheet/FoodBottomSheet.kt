package dev.efremovkirill.foodmarket.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.efremovkirill.foodmarket.databinding.FoodBottomSheetBinding

class FoodBottomSheet: BottomSheetDialogFragment() {
    private var _binding: FoodBottomSheetBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FoodBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }
}