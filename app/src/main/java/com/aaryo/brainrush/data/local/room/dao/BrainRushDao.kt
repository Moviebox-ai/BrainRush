package com.aaryo.brainrush.data.local.room.dao

import androidx.room.*
import com.aaryo.brainrush.data.local.room.entity.*
import kotlinx.coroutines.flow.Flow

@Dao interface BrainRushDao {
    @Query("SELECT * FROM players WHERE id = :id") fun observePlayer(id: String = "guest"): Flow<PlayerEntity?>
    @Query("SELECT * FROM levels ORDER BY id") fun observeLevels(): Flow<List<LevelEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsertPlayer(player: PlayerEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsertLevels(levels: List<LevelEntity>)
}
