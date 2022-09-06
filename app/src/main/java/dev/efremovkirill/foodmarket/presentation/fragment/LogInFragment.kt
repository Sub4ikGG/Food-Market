package dev.efremovkirill.foodmarket.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import dev.efremovkirill.foodmarket.presentation.viewmodel.LogInViewModel
import dev.efremovkirill.foodmarket.R

class LogInFragment : Fragment() {

    private lateinit var viewModel: LogInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LogInViewModel::class.java]

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_mainFragment)
        }
    }

    companion object {
        fun newInstance() = LogInFragment()
    }
}