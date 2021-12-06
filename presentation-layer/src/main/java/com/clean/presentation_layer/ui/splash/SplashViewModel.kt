package com.clean.presentation_layer.ui.splash

import android.os.SystemClock
import androidx.lifecycle.ViewModel
import com.clean.data_layer.local.SharedPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedPrefs: SharedPrefs
) : ViewModel() {

    companion object {
        const val WORK_DURATION = 2000L
    }

    private val initTime = SystemClock.uptimeMillis()
    fun isDataReady() = SystemClock.uptimeMillis() - initTime > WORK_DURATION

    fun isUserLogin(): Boolean {
        return sharedPrefs.getUser() != null
    }

}