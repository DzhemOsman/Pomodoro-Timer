package org.pomodoro.timer.util

// Die Verknüpfung zu unserer wakelock.js
private external fun requestWakeLockJS()
private external fun releaseWakeLockJS()

actual object WakeLockManager {
    actual fun acquire() {
        // Wir rufen JS auf
        try {
            requestWakeLockJS()
        } catch (e: Exception) {
            println("Fehler beim WakeLock aktivieren: $e")
        }
    }

    actual fun release() {
        try {
            releaseWakeLockJS()
        } catch (e: Exception) {
            println("Fehler beim WakeLock freigeben: $e")
        }
    }
}