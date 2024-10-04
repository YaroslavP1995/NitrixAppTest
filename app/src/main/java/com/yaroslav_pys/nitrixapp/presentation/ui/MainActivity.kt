package com.yaroslav_pys.nitrixapp.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.yaroslav_pys.nitrixapp.R
import com.yaroslav_pys.nitrixapp.databinding.ActivityMainBinding
import com.yaroslav_pys.nitrixapp.presentation.viewmodels.ShowVideoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.hostContainer) as NavHostFragment).navController
        navController.setGraph(R.navigation.main_nav)
    }
}

