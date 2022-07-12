package com.example.subscriptionreminder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.subscriptionreminder.databinding.BottomModalHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet  : BottomSheetDialogFragment() {
    lateinit var binding : BottomModalHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = BottomModalHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}