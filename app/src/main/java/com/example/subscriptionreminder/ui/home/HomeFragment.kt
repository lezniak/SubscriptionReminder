package com.example.subscriptionreminder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.subscriptionreminder.databinding.HomeFragmentBinding
import com.example.subscriptionreminder.ui.login.LoginViewModel

class HomeFragment: Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}