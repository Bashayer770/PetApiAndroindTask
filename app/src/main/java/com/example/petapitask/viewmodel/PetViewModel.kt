package com.example.petapitask.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petapitask.model.Pet
import com.example.petapitask.repository.PetRepository
import kotlinx.coroutines.launch

class PetViewModel : ViewModel() {
    private val repository = PetRepository()
    
    val pets = mutableStateOf<List<Pet>>(emptyList())
    val isLoading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)

    init {
        fetchPets()
    }

    private fun fetchPets() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                pets.value = repository.getPets()
                error.value = null
            } catch (e: Exception) {
                error.value = e.message ?: "An error occurred"
            } finally {
                isLoading.value = false
            }
        }
    }
} 