package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,
    onPrimary = Color.White,
    primaryContainer = PurplePrimaryLight,
    onPrimaryContainer = PurplePrimaryDark,
    secondary = PurpleSecondary,
    onSecondary = Color.White,
    secondaryContainer = PurpleSecondaryContainer,
    onSecondaryContainer = PurplePrimaryDark,
    background = PurpleBackground,
    onBackground = PurpleText,
    surface = PurpleSurface,
    onSurface = PurpleText,
    surfaceVariant = PurplePrimaryLight,
    onSurfaceVariant = PurpleTextSecondary,
    outline = PurpleOutline
)

private val DarkColorScheme = darkColorScheme(
    primary = PurpleDarkPrimary,
    onPrimary = PurpleDarkOnPrimary,
    primaryContainer = PurpleDarkPrimaryContainer,
    onPrimaryContainer = PurpleDarkOnPrimaryContainer,
    secondary = PurpleDarkPrimary,
    onSecondary = PurpleDarkOnPrimary,
    background = PurpleDarkBackground,
    onBackground = PurpleDarkText,
    surface = PurpleDarkSurface,
    onSurface = PurpleDarkText,
    surfaceVariant = PurpleDarkPrimaryContainer,
    onSurfaceVariant = PurpleDarkTextSecondary
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
