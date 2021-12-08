package com.clean.presentation_layer.ui.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.clean.presentation_layer.R
import com.clean.presentation_layer.databinding.ActivityMainBinding
import com.clean.presentation_layer.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment)
        with(binding) {
            navView.setupWithNavController(navController)
            navView.setOnNavigationItemSelectedListener { NavigationUI.onNavDestinationSelected(it, navController) }
        }
    }
}