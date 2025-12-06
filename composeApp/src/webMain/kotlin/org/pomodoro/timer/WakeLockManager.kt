package org.pomodoro.timer

expect object WakeLockManager {
    fun acquire()
    fun release()
}