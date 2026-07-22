package com.aaryo.brainrush.domain.repository

import com.aaryo.brainrush.domain.model.*
import kotlinx.coroutines.flow.Flow

interface GameRepository { val player: Flow<Player>; fun levels(): Flow<List<Level>>; suspend fun completeLevel(result: GameResult) }
