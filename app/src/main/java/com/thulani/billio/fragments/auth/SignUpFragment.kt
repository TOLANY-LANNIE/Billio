package com.thulani.billio.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.R
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.User
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.databinding.FragmentSignUpBinding
import com.thulani.billio.util.AddDialogue
import com.thulani.billio.util.LoginInt


class SignUpFragment: Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        val application= requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = UserRepository(database)
        val factory = UserViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]

        binding.btnSignup.setOnClickListener {
            var name = "${binding.nameTF.editText?.text}"
            var surname= "${binding.surnameTF.editText?.text}"
            var email = "${binding.emailTF.editText?.text}"
            var password= "${binding.passwordTF.editText?.text}"

            if(name.isEmpty()||surname.isEmpty()||email.isEmpty()||password.isEmpty()){
                Toast.makeText(context,"Fill all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                val userItem = User(name,surname,email,password)
                viewModel.upsert(userItem)
                Toast.makeText(context,"User account created successfully", Toast.LENGTH_LONG).show()
                binding.nameTF.editText?.setText("")
                binding.surnameTF.editText?.setText("")
                binding.emailTF.editText?.setText("")
                binding.passwordTF.editText?.setText("")
            }

        }



        binding.btnLogin.setOnClickListener {
            val loginFragment = LoginFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,loginFragment,LoginFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()}
        }
        return binding.root
    }
}