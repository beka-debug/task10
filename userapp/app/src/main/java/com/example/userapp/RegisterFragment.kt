package com.example.userapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment(R.layout.register) {
    var shared : SharedPreferences? = null
    lateinit var image : EditText
    lateinit var name : EditText
    lateinit var lastname :EditText
    lateinit var age : EditText
    lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register,container,false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.imageUrlEditText)
        name = view.findViewById(R.id.nameEditText)
        lastname = view.findViewById(R.id.lastNameEditText)
        age = view.findViewById(R.id.ageEditText)
        button = view.findViewById(R.id.buttonEditText)


        shared = context?.getSharedPreferences("User", Context.MODE_PRIVATE)

        button.setOnClickListener {
            if(validations()){
                shared?.edit()?.putString("image",image.text.toString())?.apply()
                shared?.edit()?.putString("name",name.text.toString())?.apply()
                shared?.edit()?.putString("lastname",lastname.text.toString())?.apply()
                shared?.edit()?.putString("age",age.text.toString())?.apply()
            } else {
                Toast.makeText(context,"Fill all Input",Toast.LENGTH_LONG).show()
            }

        }

    }


    fun validations() : Boolean{
        return !(image.text.isEmpty() || name.text.isEmpty() || lastname.text.isEmpty() || age.text.isEmpty())
    }
}