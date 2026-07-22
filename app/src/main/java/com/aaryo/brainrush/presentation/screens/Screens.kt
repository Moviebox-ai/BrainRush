package com.aaryo.brainrush.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aaryo.brainrush.presentation.components.*
import com.aaryo.brainrush.presentation.navigation.Route
import com.aaryo.brainrush.presentation.viewmodel.HomeViewModel

@Composable fun SplashScreen(onDone: () -> Unit) { LaunchedEffect(Unit) { onDone() }; Box(Modifier.fillMaxSize().padding(24.dp)) { Text("BrainRush", style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Bold) } }
@Composable fun HomeScreen(nav: NavController, vm: HomeViewModel = hiltViewModel()) { val state by vm.state.collectAsState(); BrainRushScaffold("BrainRush") { padding -> Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { if (state.loading) LinearProgressIndicator(Modifier.fillMaxWidth()); state.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }; Text("Welcome, ${state.player.username}", style = MaterialTheme.typography.headlineMedium); Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { StatCard("Coins", state.player.coins.toString(), Modifier.weight(1f)); StatCard("Energy", state.player.energy.toString(), Modifier.weight(1f)) }; Button({ nav.navigate(Route.Levels.path) }, Modifier.fillMaxWidth()) { Text("Play Levels") }; OutlinedButton({ nav.navigate(Route.Settings.path) }, Modifier.fillMaxWidth()) { Text("Settings") } } } }
@Composable fun LevelSelectScreen(nav: NavController, vm: HomeViewModel = hiltViewModel()) { val state by vm.state.collectAsState(); BrainRushScaffold("Level Select") { padding -> LazyColumn(Modifier.padding(padding), contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) { items(state.levels) { level -> ElevatedCard(onClick = { nav.navigate(Route.Game.path) }) { Row(Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) { Text(level.title); Text("★".repeat(level.stars).ifEmpty { "New" }) } } } } } }
@Composable fun GameScreen(nav: NavController, vm: HomeViewModel = hiltViewModel()) { BrainRushScaffold("Puzzle") { padding -> Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { Text("Modular puzzle engine placeholder: add Block, Tile Match, Maze, and future puzzle implementations behind domain contracts."); Button({ nav.popBackStack() }) { Text("Complete Demo") } } } }
@Composable fun SettingsScreen() { BrainRushScaffold("Settings") { padding -> Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) { listOf("Dark Mode", "Sound", "Music", "Vibration", "Language", "Privacy Policy", "Terms & Conditions", "Delete Account").forEach { Text(it, style = MaterialTheme.typography.bodyLarge) } } } }
@Preview @Composable fun SplashPreview() = SplashScreen {}
