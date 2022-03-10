package com.graduationProject.districtofbooks

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make as snackbarMake
import android.content.Intent

open class SnackBarActivity : AppCompatActivity() {
    //Progress dialog
    lateinit var progressDialog: ProgressDialog
    //in here no need for the onCreate function, because this will be inhrited
    //function to show the Error Messages
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {
        val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view

        if (errorMessage){
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(this@SnackBarActivity, R.color.snackBarErrorMsg)
            )
        }

        else {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(this@SnackBarActivity, R.color.snackBarSuccessrMsg)
            )

        }

        //showing the snack bar
        snackBar.show()
    }

}
