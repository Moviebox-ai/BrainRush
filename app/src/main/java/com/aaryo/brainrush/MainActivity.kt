package com.aaryo.brainrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aaryo.brainrush.presentation.navigation.BrainRushNavHost
import com.aaryo.brainrush.core.theme.BrainRushTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { BrainRushTheme { BrainRushNavHost() } }
    }
}
