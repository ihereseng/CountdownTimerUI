package com.spain.countdown_timer_ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun LoadingIndicatorBar(width: Dp, height: Dp, loadingPercent: Float) {
    val widthInPx = with(LocalDensity.current) { width.toPx() }
    val heightInPx = with(LocalDensity.current) { height.toPx() }
    val loadingWidth =  widthInPx * loadingPercent

    Canvas(modifier = Modifier
        .width(width)
        .height(height), onDraw = {
        drawRect(color = Color.Black, size = Size(widthInPx, heightInPx), topLeft = Offset.Zero)
        drawRect(color = Color.Red, size = Size(loadingWidth, heightInPx), topLeft = Offset.Zero)
    })
}

@Preview
@Composable
fun PreviewSampleComponent() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LoadingIndicatorBar(300.dp, 200.dp, 0.7f)
    }
}