package com.thulani.billio.fragments.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.BillioActivity
import com.thulani.billio.R
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.databinding.FragmentLoginBinding
import org.kodein.di.android.kodein


class LoginFragment: Fragment(){
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


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
            }else{
               viewModel.login(email,password)
                val user = viewModel.userDetails
                if (user != null&& user.email==email && user.password ==password) {
                    Log.i("Billio Login Fragment", user.name)
                    requireActivity().run {
                        val intent= Intent(this, BillioActivity::class.java)
                        intent.putExtra("name",user.name)
                        intent.putExtra("email",user.email)
                        intent.putExtra("surname",user.surname)
                        startActivity(intent)
                        finish()
                    }
                }else{
                    Toast.makeText(context,"Wrong Email Address or Password", Toast.LENGTH_LONG).show()
                    binding.usernameTextField.editText?.setText("")
                    binding.passwordTextField.editText?.setText("")
                }
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