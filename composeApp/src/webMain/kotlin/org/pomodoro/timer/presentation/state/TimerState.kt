package org.pomodoro.timer.presentation.state

import org.pomodoro.timer.presentation.viewmodel.formatTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

data class TimerState(
    val timeRemaining: Duration = STANDARD_TIME,
    val timeFormatted: String = STANDARD_TIME.formatTime(),
    val pauseRemaining: Duration = STANDARD_PAUSE,
    val pauseFormatted: String = STANDARD_PAUSE.formatTime(),
    val progress: Float = 1f,
    val timerMode: TimerMode = TimerMode.NotStarted,
    val isMenuExpanded: Boolean = false,
    val inEditTime: Boolean = false,
    val inEditPause: Boolean = false,
    val showEditAlert: Boolean = false,
)

sealed class TimerMode {
    data object NotStarted : TimerMode()
    data object Running : TimerMode()
    data object Paused : TimerMode()
}

val STANDARD_TIME = 25.minutes
val STANDARD_PAUSE = 5.minutes