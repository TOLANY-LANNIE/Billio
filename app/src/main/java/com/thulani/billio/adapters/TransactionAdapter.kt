package com.thulani.billio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thulani.billio.R
import com.thulani.billio.data.entities.Transactions
import com.thulani.billio.fragments.transactions.TransactionViewModel
import java.text.SimpleDateFormat
import java.util.*

class TransactionAdapter(
    val transactions:List<Transactions>,
    private var transactionViewModel:TransactionViewModel
):RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>(){
    inner class TransactionViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textTransDesc: TextView = itemView.findViewById(R.id.transName)
        val textTransAmount: TextView = itemView.findViewById(R.id.transAmount)
        val textTransDate: TextView = itemView.findViewById(R.id.transDate)
        val textTransCategory: TextView = itemView.findViewById(R.id.transCategory)
        val textTransUser: TextView = itemView.findViewById(R.id.transEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.transaction_cardview,parent,false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val currentTrans = transactions[position]
        holder.textTransDesc.text = currentTrans.name
        holder.textTransAmount.text =currentTrans.amount.toString()
        val currentDate =  currentTrans.date
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        holder.textTransDate.text =dateFormat.format(currentDate).toString()
        holder.textTransCategory.text =currentTrans.categoryID.toString()
        holder.textTransUser.text =transactionViewModel.getAllTransactionsByUser(currentTrans.userID).toString()
    }

    override fun getItemCount(): Int {
       return transactions.size
    }

}