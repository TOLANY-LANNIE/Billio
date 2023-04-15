package com.thulani.billio

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.thulani.billio.data.entities.User
import com.thulani.billio.util.AddDialogue

class TestUserDialogue(context: Context, var addDialogue: AddDialogue):AppCompatDialog(context){
    lateinit var textName: EditText
    lateinit var textSurname: EditText
    lateinit var textEmail: EditText
    lateinit var textPassword: EditText
    lateinit var btnAdd: Button
    lateinit var btnCancel:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_dialogue)
        textName = findViewById<EditText>(R.id.nameTF)!!
        textSurname = findViewById<EditText>(R.id.surnameTF)!!
        textEmail = findViewById<EditText>(R.id.emailTF)!!
        textPassword= findViewById<EditText>(R.id.passwordTF)!!
        btnAdd = findViewById<Button>(R.id.buttonAdd)!!
        btnCancel = findViewById<Button>(R.id.buttonCancel)!!


        btnAdd.setOnClickListener {
            var name =textName.text.toString()
            var surname= textSurname.text.toString()
            var email = textEmail.text.toString()
            var password= textPassword.text.toString()

            if(name.isEmpty()||surname.isEmpty()||email.isEmpty()||password.isEmpty()){
                Toast.makeText(context,"Fill all fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val userItem = User(name,surname,email,password)
            addDialogue.addButtonClicked(userItem)
            dismiss()
        }
        btnCancel.setOnClickListener {
            cancel()
        }
    }

}