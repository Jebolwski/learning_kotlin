package com.example.greetingcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CommentDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment_detail)
        supportActionBar?.hide()
        var intent = intent
        val detailed_comment = intent.getSerializableExtra("comment") as MyDataItem
        var name = findViewById<TextView>(R.id.name)
        var body = findViewById<TextView>(R.id.body)
        var email = findViewById<TextView>(R.id.email)
        println(detailed_comment.name+" "+detailed_comment.body+" MAİL:"+detailed_comment.email)
        name.text = detailed_comment.name
        body.text = detailed_comment.body
        email.text = detailed_comment.email

    }
}