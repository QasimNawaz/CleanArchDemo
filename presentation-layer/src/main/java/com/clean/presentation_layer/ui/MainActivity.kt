package com.clean.presentation_layer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clean.presentation_layer.databinding.ActivityMainBinding
import com.clean.presentation_layer.utils.viewbinding.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}