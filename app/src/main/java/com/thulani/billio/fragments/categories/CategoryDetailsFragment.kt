package com.thulani.billio.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.R
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.data.repository.CategoryRepository
import com.thulani.billio.databinding.FragmentCategoryDetailsBinding
import com.thulani.billio.fragments.auth.UserViewModel

class CategoryDetailsFragment : Fragment() {
    private var _binding: FragmentCategoryDetailsBinding? = null
    private val binding get() = _binding!!

    //fragments
    val categoriesFragment = CategoriesFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //_binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        _binding =FragmentCategoryDetailsBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24) // Replace with your back button icon
        }


        //fragments
        val categoriesFragment = CategoriesFragment()
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
    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Add category" // Set the desired title for the toolbar
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                replaceFragment(categoriesFragment)
                //requireActivity().onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }

}