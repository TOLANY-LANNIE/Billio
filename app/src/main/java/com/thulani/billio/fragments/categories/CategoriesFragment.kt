package com.thulani.billio.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.thulani.billio.R
import com.thulani.billio.adapters.CategoryAdapter
import com.thulani.billio.adapters.UserItemAdapter
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.CategoryRepository
import com.thulani.billio.data.repository.UserRepository
import com.thulani.billio.databinding.FragmentCategoriesBinding
import com.thulani.billio.fragments.auth.UserViewModel
import com.thulani.billio.fragments.auth.UserViewModelFactory

class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        //fragments
        val categoryDetails = CategoryDetailsFragment()

        val application= requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository: CategoryRepository = CategoryRepository(database)
        val factory = CategoriesViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[CategoriesViewModel::class.java]

        //val repository = UserRepository(database)
        //val factory = UserViewModelFactory(repository )
        //val viewModel = ViewModelProvider(this,factory)[UserViewModel::class.java]

        //val userItemAdapter = UserItemAdapter(listOf(),viewModel)

        val categoryAdapter = CategoryAdapter(listOf(),viewModel)


        binding.categoryListRV.layoutManager =LinearLayoutManager(activity)
        binding.categoryListRV.adapter = categoryAdapter

        viewModel.getAllCategories().observe(viewLifecycleOwner, Observer {
            categoryAdapter.categories =it
            categoryAdapter.notifyDataSetChanged()
        })


        binding.categoryFab.setOnClickListener {
            //Toast.makeText(context,"Fab clicked", Toast.LENGTH_LONG).show()
            replaceFragment(categoryDetails)
        }
        return binding.root
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}