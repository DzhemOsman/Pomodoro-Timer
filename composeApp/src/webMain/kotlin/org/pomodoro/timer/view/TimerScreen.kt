package org.pomodoro.timer.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.presentation.viewmodel.TimerEvent

@Composable
fun TimerScreen(
    state: TimerState,
    onEvent: (TimerEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TimeCard(state)
        Spacer(Modifier.height(20.dp))
        TimerControls(
            state = state,
            onEvent = onEvent
        )
    }
}