package org.pomodoro.timer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform