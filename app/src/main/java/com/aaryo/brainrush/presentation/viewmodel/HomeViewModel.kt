package com.aaryo.brainrush.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaryo.brainrush.domain.model.*
import com.aaryo.brainrush.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(val loading: Boolean = true, val player: Player = Player(), val levels: List<Level> = emptyList(), val error: String? = null)

@HiltViewModel
class HomeViewModel @Inject constructor(observePlayer: ObservePlayerUseCase, observeLevels: ObserveLevelsUseCase, private val completeLevel: CompleteLevelUseCase) : ViewModel() {
    val state: StateFlow<HomeUiState> = combine(observePlayer(), observeLevels()) { p, l -> HomeUiState(false, p, l) }.catch { emit(HomeUiState(loading = false, error = it.message)) }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())
    fun finishDemoLevel(level: Level) = viewModelScope.launch { completeLevel(GameResult(level.id, 12, 45, 3, 30)) }
}
