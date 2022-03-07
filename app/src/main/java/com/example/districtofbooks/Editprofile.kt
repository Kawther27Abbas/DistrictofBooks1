package com.example.districtofbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Editprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        //Going Back FloatingButton
        val backToProfile: FloatingActionButton = findViewById<FloatingActionButton>(R.id.backToProfile)
        backToProfile.setOnClickListener {

            val intentBack = Intent(this, StartActivity::class.java)
            startActivity(intentBack)
        }
    }
}