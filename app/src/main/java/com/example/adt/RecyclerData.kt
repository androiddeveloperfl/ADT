package com.example.adt

// TODO: include Name, Status, Species and an image of the character
data class RecyclerList(val results: List<RecyclerData>)
data class RecyclerData(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
//data class Characters(val characters: String)