package com.spain.countdowntimerui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spain.countdown_timer_ui.LoadingIndicatorBar

class MainActivity : ComponentActivity() {
    private val fakeLoadingViewModel by lazy {
        FakeLoadingViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Button(onClick = {
                    fakeLoadingViewModel.startTimer()
//                    Log.d("timer.start()", "timer instance $timer")
                }) {
                    Text(text = "Start Count")
                }
                Button(onClick = {
//                    Log.d("timer.cancel()", "timer instance $timer")
                    fakeLoadingViewModel.stopTimer()
                }) {
                    Text(text = "Stop Count")
                }
                Text(text = "Percent : ${fakeLoadingViewModel.loadingPercent}")
                LoadingIndicatorBar(
                    width = 200.dp,
                    height = 50.dp,
                    loadingPercent = fakeLoadingViewModel.loadingPercent / 100
                )
            }
        }
    }
}