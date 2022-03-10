package com.graduationProject.districtofbooks

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

@Suppress("DEPRECATION")
class SignUpActivity : SnackBarActivity() {

    //email pattern and username
    val checkSpaces = Regex ("\\A\\w{1,25}\\z")
    val emailPattern = Regex("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})")
   // val passwordPattern = Regex("(?=.*[a-zA-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\s+$)"+".{8,}"+"$")
   //val phonePattern = Regex("(/d)")



    // Initialize Firebase Auth
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //intilizing auth object
        mAuth = Firebase.auth

        //views binding




        //getting back to start Activity
        backStartFromSignup.setOnClickListener {
            onBackPressed()
            /*val intentback = Intent(this, StartActivity::class.java)
            startActivity(intentback)*/
        }

        //Already have an account
        AlredyRegistreTxt.setOnClickListener {
            val intentHaveAccount = Intent(this, LoginActivity::class.java)
            startActivity(intentHaveAccount)
        }

        //Starting the authentication, by setting on click listener to sign up btn
        signUpButtonRegister.setOnClickListener(){
            performAuthentication()
        }
    }

    /*
        Valdationg the user date
     */
    private fun validateSignUpData(): Boolean {
        return when {
        //checking for username emptiness
            TextUtils.isEmpty(inputUsername.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_username), true)
                false /*the function should return false*/
            }


        //checking for non-english letters, space, charcters not _ and length
            (inputUsername.text.toString().length>=25 && inputUsername.text.toString().length<6)
                    /*|| (!inputUsername.text.toString().matches(checkSpaces))*/-> {
                showErrorSnackBar(resources.getString(R.string.err_msg_proper_username), true)
                false
            }


        //checking for full name
            TextUtils.isEmpty(inputFullName.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_full_name), true)
                false /*the function should return false*/
            }

        //checking for password emptiness and length
            TextUtils.isEmpty(inputPassword.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

           /* (!inputPassword.text.toString().matches(passwordPattern)) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_correct_password), true)
                false
            }*/


        //checking for confirm password matching and emptiness
            TextUtils.isEmpty(confirmPassword.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            (inputPassword.text.toString().trim { it<= ' ' }) != (confirmPassword.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_mismatch), true)
                false
            }


        //phone number emptiness and length and start with 05 and free from charcters
            TextUtils.isEmpty(PhoneNum.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_phone_number), true)
                false
            }

            /*(!PhoneNum.text.toString().matches(phonePattern))-> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_proper_phone_number), true)
                false
            }*/


        //cheking for email emptiness and validation
            TextUtils.isEmpty(inputEmail.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            /*(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.text.toString().trim{it <= ' '}).matches()) */
            (!inputEmail.text.toString().matches(emailPattern)) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_proper_email), true)
                false
            }

            else -> {
                showErrorSnackBar(resources.getString(R.string.success_msg_validation_info), false)
                true
            }
        }

        }
    private fun performAuthentication() /*Boolean*/ {
        //intilizing the input field

        val usernameField: String = inputUsername.text.toString().trim { it <= ' '}
        val passwordField: String = inputPassword.text.toString().trim { it <= ' '}
        val phoneNumberField: String = PhoneNum.text.toString().trim { it <= ' '}
        val emailField: String = inputEmail.text.toString().trim { it <= ' '}
        progressDialog = ProgressDialog(this)

        if(validateSignUpData()){

            progressDialog.setMessage("please wait while registration")
            progressDialog.setTitle("Registration")
            progressDialog.setCanceledOnTouchOutside(false)
            progressDialog.show()

            mAuth.createUserWithEmailAndPassword(emailField, passwordField).addOnCompleteListener(this) {

                if (it.isSuccessful){
                    val firebaseUser: FirebaseUser = it.result!!.user!!

                    Toast.makeText(this@SignUpActivity, resources.getString(R.string.msg_sccessful_rgister), Toast.LENGTH_SHORT).show()
                    signUpUser()
                    progressDialog.dismiss()
                }
                else {
                    Toast.makeText(this@SignUpActivity, " "+it.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }

            }
        }
        else {
                validateSignUpData()

        }



    }

    private fun signUpUser(){
        val intentSignup = Intent(this, HomePageActivity::class.java)
        intentSignup.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intentSignup)
        finish()
    }

}










