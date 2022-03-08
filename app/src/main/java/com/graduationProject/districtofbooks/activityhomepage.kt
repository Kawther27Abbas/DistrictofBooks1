package com.graduationProject.districtofbooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class activityhomepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activityhomepage)

        //intilization and declaration of the  buttons in Upload Activty
        val addBook : Button = findViewById <Button>(R.id.add_book_button)


        //defining the action listener to start an Activty for sign in and sign up
        addBook.setOnClickListener {

            val intentAddBook = Intent(this, Upload_book_Activity::class.java)
            startActivity(intentAddBook)
        }
    }
}