package com.aaryo.brainrush.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "levels") data class LevelEntity(@PrimaryKey val id: Int, val type: String, val title: String, val unlocked: Boolean, val stars: Int)
@Entity(tableName = "players") data class PlayerEntity(@PrimaryKey val id: String, val username: String, val xp: Int, val coins: Int, val gems: Int, val energy: Int)
