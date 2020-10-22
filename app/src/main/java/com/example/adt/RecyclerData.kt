package com.example.adt

data class RecyclerList(val results: List<RecyclerData>)
data class RecyclerData(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
