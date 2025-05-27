package com.example.petapitask.repository

import com.example.petapitask.model.Pet
import com.example.petapitask.network.RetrofitClient

class PetRepository {
    private val api = RetrofitClient.petApi

    suspend fun getPets(): List<Pet> {
        return api.getPets()
    }
} 