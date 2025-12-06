package org.pomodoro.timer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import org.pomodoro.timer.presentation.viewmodel.TimerViewModel
import org.pomodoro.timer.view.TimerContainer
import org.pomodoro.timer.view.theme.AppTheme

@Composable
fun App() {
    AppTheme {

        val viewModel = remember { TimerViewModel() }
        val state by viewModel.state.collectAsState()

        TimerContainer(
            state = state,
            onEvent = viewModel::onEvent,
        )
    }
}