package com.clean.presentation_layer.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clean.presentation_layer.databinding.ActivityAuthBinding
import com.clean.presentation_layer.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityAuthBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}