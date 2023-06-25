package com.thulani.billio.fragments.transactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.thulani.billio.R
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


        return binding.root
    }

}