package com.gonzalo.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors

private val DarkColorPalette = darkColors(
    primary = Purple40,
    primaryVariant = Purple80,
    secondary = Pink40
)

private val LightColorPalette = lightColors(
    primary = PurpleGrey40,
    primaryVariant = PurpleGrey80,
    secondary = Pink80

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
