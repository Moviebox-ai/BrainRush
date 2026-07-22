package com.aaryo.brainrush.domain.model

enum class PuzzleType { Block, TileMatch, ColorConnect, Number, Memory, Sliding, Maze, Pattern }
data class Player(val id: String = "guest", val username: String = "Guest", val xp: Int = 0, val coins: Int = 0, val gems: Int = 0, val energy: Int = 25)
data class Level(val id: Int, val type: PuzzleType, val title: String, val unlocked: Boolean, val stars: Int = 0)
data class GameResult(val levelId: Int, val moves: Int, val seconds: Int, val stars: Int, val rewardCoins: Int)
