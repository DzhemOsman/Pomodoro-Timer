package org.pomodoro.timer.view.theme


import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import pomodoro_timer.composeapp.generated.resources.*

@Composable
fun bodyFontFamily() = FontFamily(
    Font(Res.font.varela_round_regular, FontWeight.Normal)
)

@Composable
fun displayFontFamily() = FontFamily(
    Font(Res.font.quicksand_regular, FontWeight.Normal),
    Font(Res.font.quicksand_medium, FontWeight.Medium),
    Font(Res.font.quicksand_bold, FontWeight.Bold),
    Font(Res.font.quicksand_semi_bold, FontWeight.SemiBold),
    Font(Res.font.quicksand_light, FontWeight.Light)
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography: Typography
    @Composable
    get() {
        // Jetzt sind wir in einem Composable Scope und dürfen die Fonts laden!
        val displayFont = displayFontFamily()
        val bodyFont = bodyFontFamily()

        return Typography(
            displayLarge = baseline.displayLarge.copy(fontFamily = displayFont),
            displayMedium = baseline.displayMedium.copy(fontFamily = displayFont),
            displaySmall = baseline.displaySmall.copy(fontFamily = displayFont),

            headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFont),
            headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFont),
            headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFont),

            titleLarge = baseline.titleLarge.copy(fontFamily = displayFont),
            titleMedium = baseline.titleMedium.copy(fontFamily = displayFont),
            titleSmall = baseline.titleSmall.copy(fontFamily = displayFont),

            bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFont),
            bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFont),
            bodySmall = baseline.bodySmall.copy(fontFamily = bodyFont),

            labelLarge = baseline.labelLarge.copy(fontFamily = bodyFont),
            labelMedium = baseline.labelMedium.copy(fontFamily = bodyFont),
            labelSmall = baseline.labelSmall.copy(fontFamily = bodyFont),
        )
    }