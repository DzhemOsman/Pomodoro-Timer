package org.pomodoro.timer.presentation.state

import org.pomodoro.timer.presentation.viewmodel.formatTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class TimerState(
    val timeRemaining: Duration = 25.minutes,
    val timeFormatted: String = timeRemaining.formatTime(),
    val timerMode: TimerMode = TimerMode.NotStarted
)

sealed class TimerMode {
    data object NotStarted : TimerMode()
    data object Running : TimerMode()
    data object Paused : TimerMode()
}
