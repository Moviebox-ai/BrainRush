package com.aaryo.brainrush.data.mapper

import com.aaryo.brainrush.data.local.room.entity.*
import com.aaryo.brainrush.domain.model.*

fun LevelEntity.toDomain() = Level(id, PuzzleType.valueOf(type), title, unlocked, stars)
fun PlayerEntity.toDomain() = Player(id, username, xp, coins, gems, energy)
fun Level.toEntity() = LevelEntity(id, type.name, title, unlocked, stars)
fun Player.toEntity() = PlayerEntity(id, username, xp, coins, gems, energy)
