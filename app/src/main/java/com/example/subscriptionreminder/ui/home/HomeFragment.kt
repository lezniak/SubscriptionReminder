package com.example.subscriptionreminder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.subscriptionreminder.databinding.HomeFragmentBinding
import com.example.subscriptionreminder.infrastructure.model.Subscription
import com.example.subscriptionreminder.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding : HomeFragmentBinding
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)
        layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.subscriptionList.observe(viewLifecycleOwner) {
            setupRecycleView(it)
        }
    }

    fun setupRecycleView(list: List<Subscription>): Int{
        return try {
            val adapter = HomeAdapter(list,requireContext())
            binding.recycleView.adapter = adapter
            binding.recycleView.layoutManager = layoutManager
            1
        }catch (ex: Exception){
            0
        }
    }
}