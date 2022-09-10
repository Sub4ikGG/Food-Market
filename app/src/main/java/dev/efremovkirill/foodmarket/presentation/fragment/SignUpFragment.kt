package dev.efremovkirill.foodmarket.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.navigation.fragment.findNavController
import dev.efremovkirill.foodmarket.R
import dev.efremovkirill.foodmarket.data.animateClick
import dev.efremovkirill.foodmarket.data.di.App
import dev.efremovkirill.foodmarket.data.isValidEmail
import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.usecase.SignUpUserByPhoneNumberUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

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

        try {
            val loginTextView = view.findViewById<TextView>(R.id.log_in_textView)
            val signUpButton = view.findViewById<Button>(R.id.sign_up_button)

            val userNameEditText = view.findViewById<EditText>(R.id.name_editText)
            val userPhoneNumberEditText = view.findViewById<EditText>(R.id.phone_editText)
            val userEmailEditText = view.findViewById<EditText>(R.id.email_editText)
            val userPasswordEditText = view.findViewById<EditText>(R.id.password_editText)

            setupClickListeners(
                loginTextView,
                signUpButton,
                userNameEditText,
                userPhoneNumberEditText,
                userEmailEditText,
                userPasswordEditText
            )
        }
        catch (e: Exception) {
            println(e.message)
        }
    }

    private fun setupClickListeners(
        loginTextView: TextView,
        signUpButton: Button,
        userNameEditText: EditText,
        userPhoneNumberEditText: EditText,
        userEmailEditText: EditText,
        userPasswordEditText: EditText
    ) {
        loginTextView.setOnClickListener {
            findNavController().popBackStack()
        }

        signUpButton.setOnClickListener {
            signUpButton.animateClick {
                val name = userNameEditText.text.toString()
                val phoneNumber = userPhoneNumberEditText.text.toString()
                val email = userEmailEditText.text.toString()
                val password = userPasswordEditText.text.toString()

                if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty())
                    return@animateClick Toast.makeText(
                        requireContext(),
                        "All fields must be filled",
                        Toast.LENGTH_SHORT
                    ).show()

                if(!phoneNumber.isDigitsOnly() || phoneNumber.length != 11)
                    return@animateClick Toast.makeText(
                        requireContext(),
                        "Phone number must contains only 11 digits",
                        Toast.LENGTH_SHORT
                    ).show()

                if(!email.isValidEmail())
                    return@animateClick Toast.makeText(
                        requireContext(),
                        "Please type valid email",
                        Toast.LENGTH_SHORT
                    ).show()

                if(password.length < 4)
                    return@animateClick Toast.makeText(
                        requireContext(),
                        "Password length must be more than 4",
                        Toast.LENGTH_SHORT
                    ).show()

                CoroutineScope(Dispatchers.IO).launch {
                    val user = UserModel(
                        userNameEditText.text.toString(),
                        userPhoneNumberEditText.text.toString(),
                        userEmailEditText.text.toString(),
                        userPasswordEditText.text.toString()
                    )

                    if (signUpUserByPhoneNumber.execute(user)) {
                        launch(Dispatchers.Main) {
                            Toast.makeText(
                                requireContext(),
                                "Sign up successful!",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().popBackStack()
                        }
                    } else {
                        launch(Dispatchers.Main) {
                            Toast.makeText(
                                requireContext(),
                                "Sign up unsuccessful..",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }

            }
        }
    }
}