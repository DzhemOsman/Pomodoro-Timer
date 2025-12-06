package org.pomodoro.timer

// Die externen JS-Funktionen (müssen exakt so heißen wie in deiner youtube_interop.js)
private external fun startMusicJS()
private external fun stopMusicJS()

actual object AudioPlayer {
    actual fun play() {
        try {
            startMusicJS()
        } catch (e: Exception) {
            println("Fehler bei Audio Play: $e")
        }
    }

    actual fun pause() {
        try {
            stopMusicJS()
        } catch (e: Exception) {
            println("Fehler bei Audio Pause: $e")
        }
    }
}