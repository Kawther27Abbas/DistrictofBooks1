package com.graduationProject.districtofbooks
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

@Suppress("DEPRECATION")
class LoginActivity : SnackBarActivity() {

   // val checkSpaces = Regex ("\\A\\w{1,25}\\z")
    val emailPattern = Regex("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})")
    //val phonePattern = Regex("/d")

    //creating the object
    lateinit var uAuth: FirebaseAuth
    
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //the authentication object initialization
        uAuth = FirebaseAuth.getInstance()
        
        

        //backing to start page Button
        backToStartFromLogin.setOnClickListener {

            /*val intentback = Intent(this@LoginActivity, StartActivity::class.java)
            startActivity(intentback)
            //finish function used to finish login Activity
            finish()*/
            onBackPressed()
        }

        /*signUpWithGoogle2.setOnClickListener {
            signInWithGoogle()
        }*/

        //The login process
        LoginButton.setOnClickListener {
            loginToApp()
        }

        //the rest password
        Forget_password.setOnClickListener{
            val intentResetPass = Intent(this@LoginActivity, ResetPassword::class.java)
            startActivity(intentResetPass)
        }

    }

    private fun signInWithGoogle() {

    }

    //logic to Login
    private fun loginToApp() {


        //valdition of the info typed
        when {
            //checking for username emptiness
            TextUtils.isEmpty(inputLogin.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
            }

            TextUtils.isEmpty(inputPasswordLogin.text.toString().trim{it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
            }

            else -> {
                val emailField = inputLogin.text.toString().trim { it <= ' ' }
                val passwordField1 = inputPasswordLogin.text.toString().trim { it <= ' ' }


                progressDialog = ProgressDialog(this)
                progressDialog.setMessage("please wait while Login you in")
                progressDialog.setTitle("Logged in")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()
                //login with email and password
                uAuth.signInWithEmailAndPassword(emailField, passwordField1).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this@LoginActivity, resources.getString(R.string.msg_sccessful_login), Toast.LENGTH_SHORT).show()

                        //moving to the home
                        val intentLogin = Intent(this@LoginActivity, HomePageActivity::class.java)
                        intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        intentLogin.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                        intentLogin.putExtra("email_id", emailField)
                        startActivity(intentLogin)
                        finish()
                    } else
                        Toast.makeText(this@LoginActivity, resources.getString(R.string.err_msg_failed_login), Toast.LENGTH_SHORT).show()

                }


            }
        }





    }

}