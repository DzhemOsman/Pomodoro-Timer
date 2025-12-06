package org.pomodoro.timer.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import org.pomodoro.timer.presentation.state.TimerState

@Composable
fun TimeCard(
    state: TimerState,
) {
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        ),
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(percent = 15),
        modifier = Modifier
            .fillMaxWidth(0.33f)
            .fillMaxHeight(0.25f)
            .safeContentPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = state.timeFormatted,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                autoSize = TextAutoSize.StepBased(
                    minFontSize = TextUnit(64f, TextUnitType.Sp),
                    maxFontSize = TextUnit(128f, TextUnitType.Sp)
                ),
            )
        }
    }
}