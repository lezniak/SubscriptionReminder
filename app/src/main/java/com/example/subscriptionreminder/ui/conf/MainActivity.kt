package com.example.subscriptionreminder.ui.conf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.subscriptionreminder.R
import com.example.subscriptionreminder.ui.login.LoginFragment
import com.example.subscriptionreminder.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .commitNow()
        }
    }
}