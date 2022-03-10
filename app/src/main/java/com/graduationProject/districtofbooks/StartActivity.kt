package com.graduationProject.districtofbooks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        //defining the action listener to start an Activty for sign in and sign up
        loginBtn.setOnClickListener {

            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
        }

        singupBtn.setOnClickListener {

            val intentSignup = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignup)
        }
    }


}