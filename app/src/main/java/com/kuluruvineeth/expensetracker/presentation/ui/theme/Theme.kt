package com.kuluruvineeth.expensetracker.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.kuluruvineeth.expensetracker.util.CompactSpacing
import com.kuluruvineeth.expensetracker.util.ExpandedSpacing
import com.kuluruvineeth.expensetracker.util.LocalSpacing
import com.kuluruvineeth.expensetracker.util.MediumSpacing
import com.kuluruvineeth.expensetracker.util.WindowInfo
import com.kuluruvineeth.expensetracker.util.rememberWindowInfo

private val DarkColorPalette = darkColors(
    primary = Indigo900,
    secondary = Indigo900,
    background = DeepPurple900,
    surface = DeepPurple300,
    error = Red200,
    onSurface = White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = LightBlue500,
    secondary = LightBlue500,
    background = Grey100,
    surface = White,
    error = Red500,
    onSurface = Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black
)

@Composable
fun ExpenseTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val windowInfo = rememberWindowInfo()

    CompositionLocalProvider(
        when (windowInfo.screenHeightInfo) {
            is WindowInfo.WindowType.Compact -> {
                LocalSpacing provides CompactSpacing()
            }
            is WindowInfo.WindowType.Medium -> {
                LocalSpacing provides MediumSpacing()
            }
            else -> LocalSpacing provides ExpandedSpacing()
        }
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}