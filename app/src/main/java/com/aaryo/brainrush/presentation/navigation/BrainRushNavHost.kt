package com.aaryo.brainrush.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.aaryo.brainrush.presentation.screens.*

sealed class Route(val path: String) { data object Splash: Route("splash"); data object Home: Route("home"); data object Levels: Route("levels"); data object Game: Route("game"); data object Settings: Route("settings") }
@Composable fun BrainRushNavHost() { val nav = rememberNavController(); NavHost(nav, Route.Splash.path) { composable(Route.Splash.path) { SplashScreen { nav.navigate(Route.Home.path) { popUpTo(Route.Splash.path) { inclusive = true } } } }; composable(Route.Home.path) { HomeScreen(nav) }; composable(Route.Levels.path) { LevelSelectScreen(nav) }; composable(Route.Game.path) { GameScreen(nav) }; composable(Route.Settings.path) { SettingsScreen() } } }
