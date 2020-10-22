package com.example.adt.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        //     private const val baseURL = "https://rickandmortyapi.com"
        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
