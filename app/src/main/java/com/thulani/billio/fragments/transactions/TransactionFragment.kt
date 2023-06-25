package com.thulani.billio.fragments.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.TransactionRepository
import com.thulani.billio.databinding.FragmentTransactionBinding


class TransactionFragment : Fragment() {
    private var _binding:FragmentTransactionBinding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentTransactionBinding.inflate(inflater, container, false)


        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false) // Remove the back button
        }

        //linked fragments
        val transactionDetailsFragment = TransactionDetailsFragment()

        //Db link
        val application = requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = TransactionRepository(database)
        val factory = TransactionViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[TransactionViewModel::class.java]


        return binding.root
    }

}