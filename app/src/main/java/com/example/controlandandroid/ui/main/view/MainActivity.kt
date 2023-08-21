package com.example.controlandandroid.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.controlandandroid.databinding.ActivityMainBinding
import com.example.controlandandroid.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavController()
    }

    override fun onCreateBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    private fun setupNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            binding.navHostFragmentContainer.id
        ) as NavHostFragment
        navController = navHostFragment.navController
    }
}