package com.example.composecharactersbase

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val specie: String
)

data class CharacterResponse(
    val results: List<CharacterModel>
)

