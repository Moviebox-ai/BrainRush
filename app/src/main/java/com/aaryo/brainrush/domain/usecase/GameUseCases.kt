package com.aaryo.brainrush.domain.usecase

import com.aaryo.brainrush.domain.model.GameResult
import com.aaryo.brainrush.domain.repository.GameRepository
import javax.inject.Inject

class ObservePlayerUseCase @Inject constructor(private val repository: GameRepository) { operator fun invoke() = repository.player }
class ObserveLevelsUseCase @Inject constructor(private val repository: GameRepository) { operator fun invoke() = repository.levels() }
class CompleteLevelUseCase @Inject constructor(private val repository: GameRepository) { suspend operator fun invoke(result: GameResult) = repository.completeLevel(result) }
