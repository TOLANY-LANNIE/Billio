package com.thulani.billio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thulani.billio.R
import com.thulani.billio.data.entities.Bills
import com.thulani.billio.fragments.bills.BillsViewModel

class BillAdapter(
    var bills:List<Bills>,
    private var billsViewModel: BillsViewModel
):RecyclerView.Adapter<BillAdapter.BillsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.bill_cardview,parent,false)
        return BillsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BillsViewHolder, position: Int) {
        val currentBill = bills[position]
        holder.textBillDesc.text = currentBill.name
        holder.textBillAmount.text = currentBill.amount.toString()
        holder.textBillDueDate.text = currentBill.date.toString()
        holder.textBillsStatus.text =currentBill.status
        holder.textBilLCategory.text =currentBill.categoryID.toString()
        holder.textBillUser.text =currentBill.uid.toString()
    }

    override fun getItemCount(): Int {
        return bills.size
    }

    inner class BillsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textBillDesc: TextView = itemView.findViewById(R.id.billName)
        val textBillAmount:TextView = itemView.findViewById(R.id.billAmount)
        val textBillDueDate:TextView = itemView.findViewById(R.id.billDueDate)
        val textBillsStatus:TextView = itemView.findViewById(R.id.billStatus)
        val textBilLCategory:TextView = itemView.findViewById(R.id.billCategory)
        val textBillUser:TextView = itemView.findViewById(R.id.billEmail)
    }
}