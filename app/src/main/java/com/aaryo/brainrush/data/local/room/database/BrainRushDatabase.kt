package com.aaryo.brainrush.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aaryo.brainrush.data.local.room.dao.BrainRushDao
import com.aaryo.brainrush.data.local.room.entity.*

@Database(entities = [LevelEntity::class, PlayerEntity::class], version = 1, exportSchema = true)
abstract class BrainRushDatabase : RoomDatabase() { abstract fun dao(): BrainRushDao }
