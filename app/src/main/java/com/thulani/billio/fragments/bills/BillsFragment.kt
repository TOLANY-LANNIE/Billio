package com.thulani.billio.fragments.bills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thulani.billio.R
import com.thulani.billio.adapters.BillAdapter
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.repository.BillRepository
import com.thulani.billio.databinding.FragmentBillsBinding

class BillsFragment : Fragment() {
    private var _binding:FragmentBillsBinding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding =FragmentBillsBinding.inflate(inflater, container, false)

        //linked fragments
        val billFragmentBillsDetails = BillDetailsFragment()
        //db connection
        val application = requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = BillRepository(database)
        val factory = BillsViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[BillsViewModel::class.java]

        //link to adapter
        val billsAdapter = BillAdapter(listOf(),viewModel)

        binding.billListRV.layoutManager =LinearLayoutManager(activity)
        binding.billListRV.adapter =billsAdapter

        viewModel.getAllBills().observe(viewLifecycleOwner, Observer{
            billsAdapter.bills =it
            billsAdapter.notifyDataSetChanged()
        })

        binding.billFab.setOnClickListener {
            //Toast.makeText(context,"Bill Fab clicked", Toast.LENGTH_LONG).show()
            replaceFragment(billFragmentBillsDetails)
        }
        return binding.root
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment,fragment)
        transaction.commit()

    }
}