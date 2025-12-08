package org.pomodoro.timer.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.presentation.viewmodel.TimerEvent
import kotlin.time.Duration.Companion.minutes

@Composable
fun TimerPicker(state: TimerState, onEvent: (TimerEvent) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        FilledIconButton(
            onClick = {
                onEvent(TimerEvent.UpdateTime(state.timeRemaining - 5.minutes))
            },
            enabled = state.timeRemaining > 1.minutes,
        ) {
            Icon(Icons.Default.Remove, contentDescription = "Decrease time")
        }
        Text(
            text = "${state.timeFormatted} Min.",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        FilledIconButton(
            onClick = {
                onEvent(TimerEvent.UpdateTime(state.timeRemaining + 5.minutes))
            },
            enabled = state.timeRemaining < 120.minutes,
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add time")
        }
    }
}