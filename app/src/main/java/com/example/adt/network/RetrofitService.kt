package com.example.adt.network

import com.example.adt.RecyclerList
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("character")
    fun getDataFromAPI(): Call<RecyclerList>

}