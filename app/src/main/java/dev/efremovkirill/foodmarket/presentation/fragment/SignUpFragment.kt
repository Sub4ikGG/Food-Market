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
import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.usecase.SignUpUserByPhoneNumberUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    private val signUpUserByPhoneNumber = SignUpUserByPhoneNumberUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(signUpUserByPhoneNumber)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginTextView = view.findViewById<TextView>(R.id.log_in_textView)
        val signUpButton = view.findViewById<Button>(R.id.sign_up_button)

        val userNameEditText = view.findViewById<EditText>(R.id.name_editText)
        val userPhoneNumberEditText = view.findViewById<EditText>(R.id.phone_editText)
        val userEmailEditText = view.findViewById<EditText>(R.id.email_editText)
        val userPasswordEditText = view.findViewById<EditText>(R.id.password_editText)

        loginTextView.setOnClickListener {
            findNavController().popBackStack()
        }

        signUpButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val user = UserModel(
                    userNameEditText.text.toString(),
                    userPhoneNumberEditText.text.toString(),
                    userEmailEditText.text.toString(),
                    userPasswordEditText.text.toString()
                )

                if(signUpUserByPhoneNumber.execute(user)) {
                    launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Sign up successful!", Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                    }
                }
                else {
                    launch(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Sign up unsuccessful..", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    companion object {
        fun newInstance() = SignUpFragment()
    }
}