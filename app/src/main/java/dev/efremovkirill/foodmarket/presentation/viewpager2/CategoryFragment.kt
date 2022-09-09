package dev.efremovkirill.foodmarket.presentation.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.efremovkirill.foodmarket.R

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(TITLE_PARAM) }?.apply {
            val nameTextView: TextView = view.findViewById(R.id.category_title_textView)
            val imageView: ImageView = view.findViewById(R.id.promo_imageView)

            nameTextView.text = getString(TITLE_PARAM)
            // Glide impl
        }
    }
}