package com.example.kotlin_learning

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val btnCall: Button = findViewById(R.id.btnCall)
        val btnBrowser: Button = findViewById(R.id.btnBrowser)
        val btnSms: Button = findViewById(R.id.btnSms)


        // Set click listeners for the buttons
        btnCall.setOnClickListener {
            // Handle the call button click
        }

        btnBrowser.setOnClickListener {
            // Handle the browser button click
            val intent = Intent(Intent.ACTION_VIEW)
               intent.data = Uri.parse("https://www.linkedin.com/in/aman-kumar-singh-210b481a4/")
               startActivity(intent)



        }

        btnSms.setOnClickListener {
            // Handle the SMS button click
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("sms:7033759086") // Receiver's phone number
            smsIntent.putExtra("sms body", "Hello, this is a test message!") // Message content
            startActivity(smsIntent)

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}