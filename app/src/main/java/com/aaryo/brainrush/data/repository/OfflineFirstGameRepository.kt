package com.aaryo.brainrush.data.repository

import com.aaryo.brainrush.core.constants.AppConstants
import com.aaryo.brainrush.data.local.room.dao.BrainRushDao
import com.aaryo.brainrush.data.local.room.entity.PlayerEntity
import com.aaryo.brainrush.data.mapper.toDomain
import com.aaryo.brainrush.data.mapper.toEntity
import com.aaryo.brainrush.domain.model.*
import com.aaryo.brainrush.domain.repository.GameRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class OfflineFirstGameRepository @Inject constructor(private val dao: BrainRushDao) : GameRepository {
    override val player = dao.observePlayer().map { it?.toDomain() ?: Player(energy = AppConstants.STARTING_ENERGY) }
    override fun levels() = dao.observeLevels().map { rows -> rows.ifEmpty { seedLevels().map(Level::toEntity) }.map { it.toDomain() } }
    override suspend fun completeLevel(result: GameResult) { dao.upsertPlayer(PlayerEntity("guest", "Guest", result.stars * 100, result.rewardCoins, 0, 24)); dao.upsertLevels(seedLevels().map { if (it.id == result.levelId) it.copy(stars = result.stars) else it }.map(Level::toEntity)) }
    private fun seedLevels() = (1..50).map { Level(it, PuzzleType.entries[it % PuzzleType.entries.size], "Puzzle $it", it == 1) }
}
