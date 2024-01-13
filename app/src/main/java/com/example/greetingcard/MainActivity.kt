package com.example.greetingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()

        val calculator = findViewById<Button>(R.id.calculator)

        calculator.setOnClickListener{
            intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}