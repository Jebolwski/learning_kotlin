package com.example.greetingcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_comments)
        supportActionBar?.hide()
        val retroifBuilder = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retroifBuilder.getData("1")

        myRecyclerView=findViewById(R.id.recyclerView)

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList = response.body()!!
                //val textView = findViewById<TextView>(R.id.sign_to_account)
                //println(response)
                //textView.text = dataList.toString()
                myAdapter = MyAdapter(this@MainActivity,dataList)
                myRecyclerView.adapter = myAdapter
                myRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                /*
                val calculator = findViewById<Button>(R.id.calculator)

                calculator.setOnClickListener{
                    intent = Intent(this,CalculatorActivity::class.java)
                    startActivity(intent)
                }
                */
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                println(t.toString())
                Log.d("fak","şlsavdaşd")
            }
        })





    }


}