package com.graduationProject.districtofbooks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        //intilization and declaration of the two button in start Activty
        val loginActivty : Button = findViewById <Button>(R.id.loginBtn)
        val signupActivitybtn : Button = findViewById<Button>(R.id.singupBtn)

        //defining the action listener to start an Activty for sign in and sign up
        loginActivty.setOnClickListener {

            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        signupActivitybtn.setOnClickListener {

            val intentSignup = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignup)
        }
    }


}