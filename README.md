# Pomodoro Timer

A modern, web-based Pomodoro Timer application built with Kotlin Multiplatform and Compose Multiplatform, designed to help you boost productivity using the Pomodoro Technique.

## What is This Project?

This is a Pomodoro Timer web application that helps you manage your time using the popular Pomodoro Technique - a time management method that uses a timer to break work into focused intervals (traditionally 25 minutes), separated by short breaks.

The application is built using:
- **Kotlin Multiplatform** for cross-platform code sharing
- **Compose Multiplatform** for building the UI
- **Kotlin/Wasm** and **Kotlin/JS** targets for web deployment

## Features

### Core Functionality
- ⏱️ **25-Minute Timer** - Standard Pomodoro interval countdown timer
- ▶️ **Start/Pause** - Control your focus sessions with ease
- 🔄 **Reset** - Restart the timer at any time
- 🎵 **Audio Support** - Background audio playback during timer sessions
- 🔒 **Wake Lock** - Prevents screen from sleeping during active sessions
- 📱 **Responsive Design** - Clean, centered UI with Material Design 3

### Technical Features
- Real-time countdown updates (1-second intervals)
- State management with Kotlin Flows and ViewModel
- Platform-specific implementations for JS and Wasm targets
- Monospace font display for clear time reading

## How to Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- No additional dependencies required (Gradle wrapper included)

### Running the Development Server

#### Option 1: WebAssembly Target (Recommended - Faster, Modern Browsers)

**macOS/Linux:**
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

**Windows:**
```bash
.\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
```

#### Option 2: JavaScript Target (Better Browser Compatibility)

**macOS/Linux:**
```bash
./gradlew :composeApp:jsBrowserDevelopmentRun
```

**Windows:**
```bash
.\gradlew.bat :composeApp:jsBrowserDevelopmentRun
```

### Building for Production

**WebAssembly:**
```bash
./gradlew :composeApp:wasmJsBrowserDistribution
```

**JavaScript:**
```bash
./gradlew :composeApp:jsBrowserDistribution
```

The production build will be available in `composeApp/build/dist/` directory.

### Using Your IDE

You can also use the run configurations from the run widget in your IDE's toolbar (IntelliJ IDEA, Android Studio, or Fleet).

## Project Structure

```
composeApp/
├── src/
│   ├── webMain/kotlin/org/pomodoro/timer/
│   │   ├── App.kt                        # Main UI composition
│   │   ├── AudioPlayer.kt                # Audio playback interface
│   │   ├── WakeLockManager.kt            # Wake lock interface
│   │   └── presentation/
│   │       ├── state/TimerState.kt       # Timer state data models
│   │       └── viewmodel/TimerViewModel.kt # Business logic & state management
│   ├── jsMain/kotlin/                    # JS-specific implementations
│   ├── wasmJsMain/kotlin/                # Wasm-specific implementations
│   └── webMain/resources/                # HTML, CSS, and JS resources
└── build.gradle.kts                      # Build configuration
```

## How to Use

1. **Start the Timer**: Click the "Start" button to begin a 25-minute focus session
2. **Pause**: Click the "Pause" button to temporarily stop the timer
3. **Reset**: Click the "Reset" button to return to 25:00
4. **Focus**: Work on a single task until the timer reaches 00:00

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Compose Multiplatform
- **Build System**: Gradle with Kotlin DSL
- **Target Platforms**: Web (JS & Wasm)
- **Architecture**: MVVM with ViewModel and StateFlow

## Learn More

- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform)
- [Kotlin/Wasm](https://kotl.in/wasm/)

## Feedback

For questions or feedback about Compose/Web and Kotlin/Wasm, visit the [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web) Slack channel.

To report issues, please use [YouTrack](https://youtrack.jetbrains.com/newIssue?project=CMP).
