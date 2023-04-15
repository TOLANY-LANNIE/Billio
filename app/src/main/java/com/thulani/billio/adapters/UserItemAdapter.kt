package com.thulani.billio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thulani.billio.R
import com.thulani.billio.data.entities.User
import com.thulani.billio.fragments.auth.UserViewModel

class UserItemAdapter(
    var users: List<User>,
    private val userViewModel: UserViewModel
): RecyclerView.Adapter<UserItemAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.test_user_item, parent, false )
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUserItem = users[position]
        holder.txtName.text = currentUserItem.name
        holder.txtSurname.text = currentUserItem.surname
        holder.txtEmail.text = currentUserItem.email
        holder.txtPassword.text = currentUserItem.password
        holder.btnDelete.setOnClickListener {
            userViewModel.delete(currentUserItem)
        }

        holder.btnUpdate.setOnClickListener {
            userViewModel.upsert(currentUserItem)
        }


    }

    override fun getItemCount(): Int {
        return  users.size
    }

    inner class UserViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val txtName:TextView = itemView.findViewById(R.id.nameTV)
        val txtSurname:TextView = itemView.findViewById(R.id.surnameTV)
        val txtEmail:TextView = itemView.findViewById(R.id.emailTV)
        val txtPassword:TextView = itemView.findViewById(R.id.passwordTV)
        val btnDelete:Button = itemView.findViewById(R.id.deleteBT)
        val btnUpdate:Button = itemView.findViewById(R.id.updateBT)
            }

}