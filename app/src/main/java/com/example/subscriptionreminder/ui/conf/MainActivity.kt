package com.example.subscriptionreminder.ui.conf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.subscriptionreminder.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavController


import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.subscriptionreminder.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.subscriptionreminder.R.layout.main_activity)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}