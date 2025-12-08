package org.pomodoro.timer.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.presentation.viewmodel.TimerEvent

@Composable
fun TimerContainer(
    state: TimerState,
    onEvent: (TimerEvent) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                if (state.isMenuExpanded) {
                    TimerMenu(onEvent = onEvent)
                }
                TimerFloatingActionButton(state = state, onEvent = onEvent)
            }
        },
    ) {
        TimerScreen(
            state = state,
            onEvent = onEvent,
        )
        if (state.showEditAlert) {
            EditDialog(state = state, onEvent = onEvent)
        }
    }
}

@Composable
fun TimerFloatingActionButton(state: TimerState, onEvent: (TimerEvent) -> Unit) {
    FloatingActionButton(onClick = { onEvent(TimerEvent.ToggleMenu) }) {
        if (state.isMenuExpanded) {
            Icon(Icons.Default.Close, contentDescription = "Close menu")
        } else {
            Icon(Icons.Default.Edit, contentDescription = "Open menu")
        }
    }
}

@Composable
fun TimerMenu(onEvent: (TimerEvent) -> Unit) {
    SmallFloatingActionButton(
        onClick = { onEvent(TimerEvent.StartEditPause) },
        containerColor = MaterialTheme.colorScheme.inverseSurface,
        contentColor = MaterialTheme.colorScheme.inverseOnSurface,
    ) {
        Icon(Icons.Default.Coffee, "Coffee menu")
    }
    SmallFloatingActionButton(
        onClick = { onEvent(TimerEvent.StartEditTime) },
        containerColor = MaterialTheme.colorScheme.inverseSurface,
        contentColor = MaterialTheme.colorScheme.inverseOnSurface,
    ) {
        Icon(Icons.Default.Timer, "Edit time")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDialog(state: TimerState, onEvent: (TimerEvent) -> Unit) {
    BasicAlertDialog(
        onDismissRequest = { onEvent(TimerEvent.DismissEdit) },
    ) {
        Card(
            colors = CardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            ),
            elevation = CardDefaults.cardElevation(),
            shape = RoundedCornerShape(percent = 15),
            modifier = Modifier
                .widthIn(min = 300.dp, max = 600.dp)
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Edit",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                TimerPicker(
                    state = state,
                    onEvent = onEvent,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                ) {
                    TextButton(
                        onClick = { onEvent(TimerEvent.DismissEdit) },
                        content = { Text("OK") },
                    )
                    Spacer(Modifier.width(8.dp))
                    TextButton(
                        onClick = { onEvent(TimerEvent.DismissEdit) },
                        content = { Text("Dismiss") },
                    )
                }
            }
        }
    }
}