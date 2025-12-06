package org.pomodoro.timer.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.pomodoro.timer.presentation.state.TimerState

@Composable
fun TimeCard(
    state: TimerState,
) {
    val animatedProgress by animateFloatAsState(
        targetValue = state.progress
    )

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
            .widthIn(min = 300.dp, max = 600.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .safeContentPadding()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 48.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.timeFormatted,
                    style = MaterialTheme.typography.displayLarge.copy(fontFeatureSettings = "tnum"),
                    fontWeight = FontWeight.Bold,
                    autoSize = TextAutoSize.StepBased(
                        minFontSize = TextUnit(64f, TextUnitType.Sp),
                        maxFontSize = TextUnit(128f, TextUnitType.Sp)
                    ),
                )
            }
            LinearProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.fillMaxWidth().height(6.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
    }
}