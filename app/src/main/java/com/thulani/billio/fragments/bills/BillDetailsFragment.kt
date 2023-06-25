package com.thulani.billio.fragments.bills

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.thulani.billio.R
import com.thulani.billio.data.BillioDB
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.data.repository.BillRepository
import com.thulani.billio.databinding.FragmentBillDetailsBinding
import java.util.*

class BillDetailsFragment : Fragment() {
   private var _binding:FragmentBillDetailsBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentBillDetailsBinding.inflate(inflater, container, false)

        //db connection
        val application = requireNotNull(this.activity).application
        val database = BillioDB.invoke(application)
        val repository = BillRepository(database)
        val factory = BillsViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[BillsViewModel::class.java]

        binding.btnAddBill.setOnClickListener {
            var billDesc = "${binding.billDescTF.editText?.text}"
            var billAmount ="${binding.billAmountTF.editText?.text}"
            var billDueDate ="${binding.billDueDateTF.editText?.text}"
            val billStatus = "${binding.billStatusTF.editText?.text}"
            var billCategory="${binding.billCategoryTF.editText?.text}"
            var billUserID ="${binding.billUserTF.editText?.text}"
            val userID ="1"
            // Create a Date object representing the current date and time
            val currentDate = Date()

            if(billDesc.isEmpty()||billAmount.isEmpty()||billDueDate.isEmpty()||
                billStatus.isEmpty()||billCategory.isEmpty()||userID.isEmpty()){
                Toast.makeText(context,"Fill out all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                val billItem = Bills(billDesc,billAmount.toDouble(),currentDate,billStatus,billCategory.toInt(),userID.toInt())
                viewModel.upsert(billItem)
                Toast.makeText(context,"Bill created successfully", Toast.LENGTH_LONG).show()
                binding.billDescTF.editText?.setText("")
                binding.billAmountTF.editText?.setText("")
                binding.billDueDateTF.editText?.setText("")
                binding.billStatusTF.editText?.setText("")
                binding.billCategoryTF.editText?.setText("")
                binding.billUserTF.editText?.setText("")
            }
        }

        binding.btnDeleteBill.setOnClickListener {

        }
        return binding.root
    }

}