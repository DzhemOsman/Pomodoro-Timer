package org.pomodoro.timer.util

// Hier definieren wir nur, was wir brauchen.
// Das ViewModel in webMain sieht diese Datei.
expect object AudioPlayer {
    fun play()
    fun pause()
}