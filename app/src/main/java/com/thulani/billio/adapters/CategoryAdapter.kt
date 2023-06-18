package com.thulani.billio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thulani.billio.R
import com.thulani.billio.data.entities.Categories
import com.thulani.billio.fragments.categories.CategoriesViewModel

class CategoryAdapter(
    var categories:List<Categories>,
    private val categoriesViewModel: CategoriesViewModel
):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cardview,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategoryItem = categories[position]
        holder.textCategoryDesc.text = currentCategoryItem.name
        holder.textCategoryAmount.text = currentCategoryItem.amount.toString()
        val userID = currentCategoryItem.userID
        holder.textCategoryUser.text =currentCategoryItem.userID.toString()
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textCategoryDesc:TextView = itemView.findViewById(R.id.categoryNameHint)
        val textCategoryAmount:TextView= itemView.findViewById(R.id.categoryAmountHint)
        val textCategoryUser:TextView= itemView.findViewById(R.id.categoryEmailHint)
    }
}