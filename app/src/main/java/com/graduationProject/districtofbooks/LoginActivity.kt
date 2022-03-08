package com.graduationProject.districtofbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //backing to start page Button
        backToStartFromLogin.setOnClickListener {

            val intentback = Intent(this, StartActivity::class.java)
            startActivity(intentback)
        }

        //The login process
        signinBtnL.setOnClickListener {
            val intentLogin = Intent(this, testActivity::class.java)
            startActivity(intentLogin)
        }

        //the rest password
        Forget_password.setOnClickListener{
            val intentResetPass = Intent(this, ResetPassword::class.java)
            startActivity(intentResetPass)
        }

    }
}