package com.example.mvvm_app.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvm_app.R
import com.example.mvvm_app.base.BaseActivity
import com.example.mvvm_app.databinding.ActivityMainBinding
import com.example.mvvm_app.features.vms.NavigationViewModel
import com.example.mvvm_app.utils.enums.NavEnum.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val navViewModel: NavigationViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null

    override fun initialize() {

    }

    override fun vmObserver() {
        navViewModel.screenValue.observe(this) {
            when (it ?: MAIN_SCREEN) {
                PEOPLE_SCREEN -> {
                    navController?.navigate(R.id.action_mainFragment_to_peopleFragment)
                }

                PLANET_SCREEN -> {
                    navController?.navigate(R.id.action_mainFragment_to_planetFragment)
                }

                FILM_SCREEN -> {
                    navController?.navigate(R.id.action_mainFragment_to_filmFragment)
                }

                MAIN_SCREEN -> TODO()
            }
        }
        super.vmObserver()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navFlashHost) as NavHostFragment
        navController = navHostFragment.navController
    }
}
