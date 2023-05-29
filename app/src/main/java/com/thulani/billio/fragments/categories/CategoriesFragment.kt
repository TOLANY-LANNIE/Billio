package com.thulani.billio.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thulani.billio.R
import com.thulani.billio.adapters.CategoryAdapter
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

        val application= requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = CategoryRepository(database)
        val factory = CategoriesViewModelFactory(repository )
        val viewModel = ViewModelProvider(this,factory)[CategoriesViewModel::class.java]


        val categoryAdapter = CategoryAdapter(listOf(),viewModel)

        binding.categoryListRV.layoutManager =LinearLayoutManager(activity)
        binding.categoryListRV.adapter = categoryAdapter



        binding.categoryFab.setOnClickListener {
            R.navigation.category_nav
        }
        return binding.root
    }
}