package org.pomodoro.timer.presentation.viewmodel

import kotlin.time.Duration

sealed interface TimerEvent {
    data object ToggleTime : TimerEvent
    data object ResetTimer : TimerEvent
    data object ToggleMenu : TimerEvent
    data object StartEditTime : TimerEvent
    data object StartEditPause : TimerEvent
    data object DismissEdit : TimerEvent

    data class UpdateTime(val minutes: Duration) : TimerEvent
    data class UpdatePause(val minutes: Duration) : TimerEvent
}