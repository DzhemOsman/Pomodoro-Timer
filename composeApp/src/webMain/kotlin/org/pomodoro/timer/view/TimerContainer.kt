package org.pomodoro.timer.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.presentation.viewmodel.TimerViewModel

@Composable
fun TimerContainer(
    state: TimerState,
    viewModel: TimerViewModel
) {
    Scaffold {
        TimerScreen(
            state = state,
            onStart = { viewModel.toggleTime() },
            onReset = { viewModel.resetTimer() }
        )
    }
}