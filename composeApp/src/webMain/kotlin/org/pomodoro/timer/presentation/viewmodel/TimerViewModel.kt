package org.pomodoro.timer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.pomodoro.timer.presentation.state.STANDARD_TIME
import org.pomodoro.timer.presentation.state.TimerMode
import org.pomodoro.timer.presentation.state.TimerState
import org.pomodoro.timer.util.AudioPlayer
import org.pomodoro.timer.util.WakeLockManager
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class TimerViewModel : ViewModel() {
    private val _state = MutableStateFlow(TimerState())
    val state = _state.asStateFlow()

    fun onEvent(event: TimerEvent) {
        when (event) {
            TimerEvent.ToggleTime -> {
                toggleTime()
            }

            TimerEvent.ResetTimer -> {
                resetTimer()
            }

            TimerEvent.PauseTime -> {
                pauseTime()
            }

            is TimerEvent.ChangeDuration -> {
                // TODO: Implement ChangeDuration event handling
                println("Warning: ChangeDuration event received but not implemented yet.")
            }
        }
    }

    private fun toggleTime() {
        if (_state.value.timerMode != TimerMode.Running) {
            _state.update {
                it.copy(timerMode = TimerMode.Running)
            }
            runTimer()
        } else {
            pauseTime()
        }

    }

    private fun pauseTime() {
        WakeLockManager.release()
        AudioPlayer.pause()
        _state.update {
            it.copy(timerMode = TimerMode.Paused)
        }
    }

    private fun resetTimer() {
        if (_state.value.timerMode == TimerMode.Running) {
            stopTimer()
            toggleTime()
        } else {
            stopTimer()
        }
    }

    private fun runTimer() {
        WakeLockManager.acquire()
        AudioPlayer.play()
        viewModelScope.launch {
            while (_state.value.timerMode == TimerMode.Running) {
                delay(1.seconds)

                if (_state.value.timerMode != TimerMode.Running) break

                val currentRemaining = _state.value.timeRemaining
                if (currentRemaining <= Duration.ZERO) {
                    stopTimer()
                    break
                }

                val newTime = currentRemaining.minus(1.seconds)

                val progress = newTime.inWholeMilliseconds.toFloat() / STANDARD_TIME.inWholeMilliseconds.toFloat()

                _state.update {
                    it.copy(timeRemaining = newTime, timeFormatted = newTime.formatTime(), progress = progress)
                }
            }
        }
    }

    private fun stopTimer() {
        WakeLockManager.release()
        AudioPlayer.pause()
        viewModelScope.coroutineContext.cancelChildren()
        _state.update {
            it.copy(
                timeRemaining = STANDARD_TIME,
                timeFormatted = STANDARD_TIME.formatTime(),
                progress = 1f,
                timerMode = TimerMode.NotStarted,
            )
        }
    }
}

fun Duration.formatTime(): String {
    return this.toComponents { minutes, seconds, _ ->

        val m = minutes.toString().padStart(2, '0')
        val s = seconds.toString().padStart(2, '0')

        "$m:$s"
    }
}