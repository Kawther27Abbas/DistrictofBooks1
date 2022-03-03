package com.example.districtofbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //backing to start page
        val backToStart: FloatingActionButton = findViewById<FloatingActionButton>(R.id.backToStartFromLogin)
        backToStart.setOnClickListener {

            val intentback = Intent(this, StartActivity::class.java)
            startActivity(intentback)
        }

        //The sign in/login process
        val loginToHome: Button = findViewById<Button>(R.id.signinBtnL)
        loginToHome.setOnClickListener {

            val intentLogin = Intent(this, activityhomepage::class.java)
            startActivity(intentLogin)
        }

        //the rest password
        val resetPassword :TextView = findViewById<TextView>(R.id.Forget_password)
        resetPassword.setOnClickListener{
            val intentResetPass = Intent(this, Reset::class.java)
            startActivity(intentResetPass)
        }

    }
}