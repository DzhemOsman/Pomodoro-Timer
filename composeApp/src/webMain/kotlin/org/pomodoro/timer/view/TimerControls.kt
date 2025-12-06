package org.pomodoro.timer.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerMode
import org.pomodoro.timer.presentation.state.TimerState

@Composable
fun TimerControls(
    state: TimerState,
    onStart: () -> Unit,
    onReset: () -> Unit,
) {
    Row {
        Button(
            onClick = onStart,
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
            modifier = Modifier.height(36.dp)
        ) { GetButtonContent(state.timerMode) }
        Spacer(Modifier.width(16.dp))
        OutlinedButton(
            onClick = onReset,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reset")
            Spacer(Modifier.width(8.dp))
            Text("Reset")
        }
    }
}

@Composable
private fun GetButtonContent(timerMode: TimerMode) {
    val text = if (timerMode != TimerMode.Running) "Start" else "Pause"
    val icon = if (timerMode != TimerMode.Running) Icons.Default.PlayArrow else Icons.Default.Pause

    Icon(
        imageVector = icon,
        contentDescription = text,
        modifier = Modifier.size(18.dp) // Kleineres Icon
    )
    Spacer(Modifier.width(8.dp)) // Abstand zwischen Icon und Text

    Text(
        text = text,
        // TIPP 3: Nutze einen Standard-Style statt AutoSize
        // 'labelLarge' ist perfekt für Buttons (ca. 14sp, Fett)
        style = MaterialTheme.typography.labelLarge
    )
}