package org.pomodoro.timer.presentation.state

import org.pomodoro.timer.presentation.viewmodel.formatTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class TimerState(
    val timeRemaining: Duration = STANDARD_TIME,
    val timeFormatted: String = STANDARD_TIME.formatTime(),
    val progress: Float = 1f,
    val timerMode: TimerMode = TimerMode.NotStarted
)

sealed class TimerMode {
    data object NotStarted : TimerMode()
    data object Running : TimerMode()
    data object Paused : TimerMode()
}

val STANDARD_TIME = 25.minutes