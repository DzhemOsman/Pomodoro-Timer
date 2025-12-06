package org.pomodoro.timer.presentation.viewmodel

sealed interface TimerEvent {
    data object ToggleTime : TimerEvent
    data object ResetTimer : TimerEvent
    data object PauseTime : TimerEvent

    data class ChangeDuration(val minutes: Int) : TimerEvent
}