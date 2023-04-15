package com.thulani.billio.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.R
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.databinding.FragmentLoginBinding


class LoginFragment: Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var  textUsername:EditText
    lateinit var textPassword:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val application= requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = UserRepository(database)
        val factory = UserViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]

        binding.buttonLogin.setOnClickListener {
            var email = "${binding.usernameTextField.editText?.text}"
            var password= "${binding.passwordTextField.editText?.text}"

            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(context,"Fill all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
        }

        binding.buttonCreateAcc.setOnClickListener {
            val signUpFragment = SignUpFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,signUpFragment,SignUpFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return binding.root
    }
}