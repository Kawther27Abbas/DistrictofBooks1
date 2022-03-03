package com.example.districtofbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //getting back to start Activity
        val backToStart: FloatingActionButton = findViewById<FloatingActionButton>(R.id.backStartFromSignup)
        backToStart.setOnClickListener {

            val intentback = Intent(this, StartActivity::class.java)
            startActivity(intentback)
        }

        //Already have an account

        val alreadyHaveAccount : TextView = findViewById<TextView>(R.id.AlredyRegistreTxt)
        alreadyHaveAccount.setOnClickListener{
            val intentHaveAccount = Intent(this, LoginActivity::class.java)
            startActivity(intentHaveAccount)
        }
    }
}