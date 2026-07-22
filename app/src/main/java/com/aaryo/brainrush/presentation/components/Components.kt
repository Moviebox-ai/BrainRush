package com.aaryo.brainrush.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable fun BrainRushScaffold(title: String, content: @Composable PaddingValues.() -> Unit) { Scaffold(topBar = { TopAppBar(title = { Text(title) }) }) { content(it) } }
@Composable fun StatCard(label: String, value: String, modifier: Modifier = Modifier) { ElevatedCard(modifier) { Column(Modifier.padding(16.dp)) { Text(label, style = MaterialTheme.typography.labelLarge); Text(value, style = MaterialTheme.typography.headlineSmall) } } }
