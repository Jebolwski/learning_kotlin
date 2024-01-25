package com.example.greetingcard

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @GET("comments")
    fun getData(@Query("postId") query:String): Call<MyData>
}