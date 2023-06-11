package com.thulani.billio.fragments.calendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thulani.billio.R
import com.thulani.billio.databinding.FragmentCalendarBinding


class CalendarFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentCalendarBinding.inflate(layoutInflater)

        return bind.root
    }
}