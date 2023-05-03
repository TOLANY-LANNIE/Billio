package com.thulani.billio.fragments.balance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thulani.billio.R
import com.thulani.billio.databinding.FragmentBalanceBinding


class BalanceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentBalanceBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return bind.root
    }

}