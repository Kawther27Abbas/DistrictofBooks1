package com.graduationProject.districtofbooks

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    //Progress dialog
    lateinit var progressDialog: ProgressDialog

    // Initialize Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //intilizing auth object
        mAuth = Firebase.auth
        //getting back to start Activity
        backStartFromSignup.setOnClickListener {

            val intentback = Intent(this, StartActivity::class.java)
            startActivity(intentback)
        }

        //Already have an account
        AlredyRegistreTxt.setOnClickListener{
            val intentHaveAccount = Intent(this, LoginActivity::class.java)
            startActivity(intentHaveAccount)
        }

        //Starting the authentication, by setting on click listener to sign up btn
        signUpButtonRegister.setOnClickListener(){
            performAuthentication()
        }
    }

    private fun performAuthentication() {
        //intilizing the input field
        val usernameField: String = inputUsername.text.toString()
        val passwordField: String = inputPassword.text.toString()
        val confirmPasswordField: String = confirmPassword.text.toString()
        val phoneNumberField: String = PhoneNum.text.toString()
        val emailField: String = inputEmail.text.toString()
        val dateOfBirth: String? = inputDOB.text.toString()
        progressDialog = ProgressDialog(this)



        //checking the user data
        if (usernameField.isBlank() || emailField.isBlank() || passwordField.isBlank() || confirmPasswordField.isBlank()|| phoneNumberField.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
        }

        else if (passwordField.isBlank() || passwordField.length<6){
            inputPassword.error = "Enter Proper password"
        }

        if (passwordField != confirmPasswordField) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT).show()
        }

        if (phoneNumberField.toInt())

        else {
            progressDialog.setMessage("please wait while registration")
            progressDialog.setTitle("Registration")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            mAuth.createUserWithEmailAndPassword(emailField, passwordField).addOnCompleteListener(this) {

                    if (it.isSuccessful){
                        progressDialog.dismiss();
                        sendToHome()
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(this, ""+it.getException(), Toast.LENGTH_SHORT).show();
                    }

            }
        }

    }

    private fun sendToHome(){
        val intentSignup = Intent(this, testActivity::class.java)

        intentSignup.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intentSignup.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intentSignup)
    }
}