package com.spain.countdowntimerui

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FakeLoadingViewModel : ViewModel() {
    var loadingPercent by mutableStateOf(0.0f)
        private set
    private val totalTime = 10000L
    private var timer = object : CountDownTimer(totalTime, 10) {
        override fun onTick(millisUntilFinished: Long) {
            loadingPercent = 100f * (totalTime - millisUntilFinished) / totalTime
        }

        override fun onFinish() {
            loadingPercent = 0.0f
        }

    }

    fun startTimer() {
        timer.start()
    }

    fun stopTimer() {
        timer.cancel()
    }
}