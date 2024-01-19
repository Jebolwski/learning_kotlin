package com.example.greetingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide()
        val retroifBuilder = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/comments/").addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retroifBuilder.getData("2")

        retrofitData.enqueue(object : Callback<MyDataItem?> {
            override fun onResponse(call: Call<MyDataItem?>, response: Response<MyDataItem?>) {
                val dataList = response.body()
                val textView = findViewById<TextView>(R.id.sign_to_account)
                textView.text = dataList.toString()
                Log.d("fak","savdsavdsad")
            }

            override fun onFailure(call: Call<MyDataItem?>, t: Throwable) {
                Log.d("fak","şlsavdaşd")
            }
        })


        val calculator = findViewById<Button>(R.id.calculator)

        calculator.setOnClickListener{
            intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }


    }


}