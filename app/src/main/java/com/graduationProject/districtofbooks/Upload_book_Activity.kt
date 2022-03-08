package com.graduationProject.districtofbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class Upload_book_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_book)

        // creating dropdown list for the book status
        val spinner_status: Spinner = findViewById(R.id.bookstatus)
        ArrayAdapter.createFromResource(this,
        R.array.bookstatus, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_status.adapter= adapter
        }

        // creating dropdown list for the genera
        val spinner_genera: Spinner = findViewById(R.id.Genera)
        ArrayAdapter.createFromResource(this,
            R.array.Genera, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_genera.adapter= adapter
        }

        // creating dropdown list for the service type
        val spinner_type: Spinner = findViewById(R.id.ServiceType)
        ArrayAdapter.createFromResource(this,
            R.array.ServiceType, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_type.adapter= adapter
        }
    }
}