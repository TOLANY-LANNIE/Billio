package com.thulani.billio.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.repository.CategoryRepository
import com.thulani.billio.databinding.FragmentCategoryDetailsBinding
import com.thulani.billio.fragments.auth.UserViewModel

class CategoryDetailsFragment : Fragment() {
    private var _binding: FragmentCategoryDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //_binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        _binding =FragmentCategoryDetailsBinding.inflate(inflater, container, false)


        val application = requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = CategoryRepository(database)
        val factory = CategoriesViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[CategoriesViewModel::class.java]


        binding.btnAddCategory.setOnClickListener {
            var categoryDesc= "${binding.categoryNameTF.editText?.text}"
            var userID = 2
            var budgetAmount ="${binding.categoryAmountTF.editText?.text}"

            if(categoryDesc.isEmpty()||budgetAmount.isEmpty()){
                Toast.makeText(context,"Fill out all fields",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                val categoryItem = Categories(categoryDesc,userID,budgetAmount.toDouble())
                viewModel.upsert(categoryItem)
                Toast.makeText(context,"Category created successfully", Toast.LENGTH_LONG).show()
                binding.categoryNameTF.editText?.setText("")
                binding.categoryAmountTF.editText?.setText("")
            }
        }


        binding.btnDeleteCategory.setOnClickListener {  }
        return binding.root
    }

}