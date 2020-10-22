package com.example.adt.network

import com.example.adt.RecyclerList
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    // TODO: include Name, Status, Species and an image of the character
    @GET("character")
    fun getDataFromAPI(): Call<RecyclerList>

//    @GET("episode")
//    fun getDataFromAPI() : Response<RecyclerList>

//    @GET("character")
//    suspend fun getAllCharacters() : Response<CharacterList>
}