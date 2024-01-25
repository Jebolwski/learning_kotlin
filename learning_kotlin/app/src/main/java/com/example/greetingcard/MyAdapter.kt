package com.example.greetingcard

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context:Activity, val dataList: MyData):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val name:TextView
        val email:TextView
        val body:TextView
        init{
            name = itemView.findViewById(R.id.name)
            email = itemView.findViewById(R.id.email)
            body = itemView.findViewById(R.id.body)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_comment,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]
        holder.body.text = currentData.body
        holder.email.text = currentData.email
        holder.name.text = currentData.name
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,CommentDetail::class.java)
            intent.putExtra("comment", dataList[position])
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}