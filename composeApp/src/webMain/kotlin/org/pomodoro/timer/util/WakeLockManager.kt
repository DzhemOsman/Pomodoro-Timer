package org.pomodoro.timer.util

expect object WakeLockManager {
    fun acquire()
    fun release()
}