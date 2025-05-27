package com.example.petapitask.network

import com.example.petapitask.model.Pet
import retrofit2.http.GET

interface PetApi {
    @GET("pets")
    suspend fun getPets(): List<Pet>
} 