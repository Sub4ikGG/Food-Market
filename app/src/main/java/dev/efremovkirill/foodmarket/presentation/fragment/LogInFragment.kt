package dev.efremovkirill.foodmarket.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.di.App
import dev.efremovkirill.foodmarket.domain.usecase.LogInUserByPhoneNumberUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogInFragment : Fragment() {

    private val logInUserByPhoneNumber = LogInUserByPhoneNumberUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(logInUserByPhoneNumber)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<Button>(R.id.login_button)
        val signUpTextView = view.findViewById<TextView>(R.id.sign_up_textView)

        val phoneNumberEditText = view.findViewById<EditText>(R.id.phone_editText)
        val passwordEditText = view.findViewById<EditText>(R.id.password_editText)

        loginButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                if(logInUserByPhoneNumber.execute(phoneNumberEditText.text.toString(), passwordEditText.text.toString())) {
                    launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Log in successful!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_logInFragment_to_foodMarketFragment2)
                    }
                }
                else {
                    launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Log in unsuccessful..", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        signUpTextView.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
    }

    companion object {
        fun newInstance() = LogInFragment()
    }
}