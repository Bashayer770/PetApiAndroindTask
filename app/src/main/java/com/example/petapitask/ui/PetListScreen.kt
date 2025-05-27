package com.example.petapitask.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.petapitask.model.Pet
import com.example.petapitask.viewmodel.PetViewModel

@Composable
fun PetListScreen(viewModel: PetViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewModel.isLoading.value -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            viewModel.error.value != null -> {
                Text(
                    text = viewModel.error.value ?: "An error occurred",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.pets.value) { pet ->
                        PetCard(pet = pet)
                    }
                }
            }
        }
    }
}

@Composable
fun PetCard(pet: Pet) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pet.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "Pet image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = pet.name,
                style = MaterialTheme.typography.headlineSmall
            )
            
            Text(
                text = "Age: ${pet.age}",
                style = MaterialTheme.typography.bodyLarge
            )
            
            Text(
                text = "Gender: ${pet.gender}",
                style = MaterialTheme.typography.bodyLarge
            )
            
            Text(
                text = if (pet.adopted) "Adopted" else "Available for adoption",
                style = MaterialTheme.typography.bodyLarge,
                color = if (pet.adopted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        }
    }
} 