package org.pomodoro.timer.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.presentation.viewmodel.TimerEvent

@Composable
fun TimerContainer(
    state: TimerState,
    onEvent: (TimerEvent) -> Unit,
) {
    Scaffold {
        TimerScreen(
            state = state,
            onEvent = onEvent,
        )
    }
}