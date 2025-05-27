package com.example.petapitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.petapitask.ui.PetListScreen
import com.example.petapitask.ui.theme.PetAPITaskTheme
import com.example.petapitask.viewmodel.PetViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetAPITaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PetListScreen(viewModel = viewModel)
                }
            }
        }
    }
}