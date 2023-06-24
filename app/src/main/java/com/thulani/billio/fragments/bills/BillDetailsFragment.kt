package com.thulani.billio.fragments.bills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thulani.billio.R
import com.thulani.billio.databinding.FragmentBillDetailsBinding

class BillDetailsFragment : Fragment() {
   private var _binding:FragmentBillDetailsBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentBillDetailsBinding.inflate(inflater, container, false)


        return binding.root
    }

}