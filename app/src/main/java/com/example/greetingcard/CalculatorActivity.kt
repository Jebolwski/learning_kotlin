package com.example.greetingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        getSupportActionBar()?.hide()

        var number1 = findViewById<EditText>(R.id.number1)
        var number2 = findViewById<EditText>(R.id.number2)
        var result = findViewById<TextView>(R.id.result)

        var add = findViewById<Button>(R.id.button1)
        var subtract = findViewById<Button>(R.id.button2)
        var multiply = findViewById<Button>(R.id.button3)
        var divide = findViewById<Button>(R.id.button4)
        var total=""

        add.setOnClickListener{
            var val1=number1.text.toString().toInt()
            var val2=number2.text.toString().toInt()
            total=(val1+val2).toString()
            result.text = "Result is : "+(total)
        }

        subtract.setOnClickListener{
            var val1=number1.text.toString().toInt()
            var val2=number2.text.toString().toInt()
            total=(val1-val2).toString()
            result.text = "Result is : "+(total)
        }

        multiply.setOnClickListener{
            var val1=number1.text.toString().toInt()
            var val2=number2.text.toString().toInt()
            total=(val1*val2).toString()
            result.text = "Result is : "+(total)
        }

        divide.setOnClickListener{
            if(number2.text.toString().toInt()==0){
                result.text = "Cant divide by 0"
            }else{
                var val1=number1.text.toString().toFloat()
                var val2=number2.text.toString().toFloat()
                total=(val1.toFloat()/val2.toFloat()).toString()
                result.text = "Result is : "+(total)
            }

        }
    }
}