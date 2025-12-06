package org.pomodoro.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerMode
import org.pomodoro.timer.presentation.viewmodel.TimerViewModel
import org.pomodoro.timer.presentation.viewmodel.formatTime

@Composable
fun App() {
    MaterialTheme {

        val viewModel = remember { TimerViewModel() }
        val state by viewModel.state.collectAsState()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = state.timeFormatted,
                style = MaterialTheme.typography.displayLarge.copy(
                    fontFamily = FontFamily.Monospace
                ),
            )
            Spacer(Modifier.height(20.dp))
            Row {
                Button(onClick = { viewModel.toggleTime() }) {
                    if (state.timerMode != TimerMode.Running) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Start")
                        Text("Start")
                    } else {
                        Icon(imageVector = Icons.Default.Pause, contentDescription = "Pause")
                        Text("Pause")
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { viewModel.resetTimer() }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reset")
                    Text("Reset")
                }
            }
        }
    }
}