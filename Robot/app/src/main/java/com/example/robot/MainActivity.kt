package com.example.robot

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnGo = findViewById(R.id.btnGO) as Button


        btnGo.setOnClickListener {
            sendGet("Go");
        }

        val btnHappy = findViewById(R.id.btnHappy) as Button


        btnHappy.setOnClickListener {
            sendGet("Happy");
        }

        val btnSad = findViewById(R.id.btnSad) as Button


        btnSad.setOnClickListener {
            sendGet("Sad");
        }


    }

    fun sendGet(type : String) {
        val url = URL("192.169.4.1/$type") // Replace with your desired URL
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET" // Set the request method to GET

        }
    }



}