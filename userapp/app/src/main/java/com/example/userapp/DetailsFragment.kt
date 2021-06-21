package com.example.userapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailsFragment : Fragment(R.layout.detale) {
    var shared : SharedPreferences? = null
    lateinit var name : TextView
    lateinit var lastname : TextView
    lateinit var age : TextView
    lateinit var image : ImageView
    var imageUrl : String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detale,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = view.findViewById(R.id.nameTxt)
        age = view.findViewById(R.id.agetxt)
        lastname = view.findViewById(R.id.lastNametxt)
        name = view.findViewById(R.id.nameTxt)
        image = view.findViewById(R.id.userImage)

        shared = context?.getSharedPreferences("User", Context.MODE_PRIVATE)
        getInfo()
    }

    override fun onResume() {
        super.onResume()
        getInfo()
    }


    fun getInfo() {
        shared?.apply {
            name.text = getString("name","No Name Saved")
            lastname.text = getString("lastname","No Lastname Saved")
            age.text = getString("age","No Age Saved")
            imageUrl = getString("image","No image Saved")

            Glide.with(this@DetailsFragment)
                .load(imageUrl)
                .into(image)
        }
    }
}