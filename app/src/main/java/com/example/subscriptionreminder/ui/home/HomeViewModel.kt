package com.example.subscriptionreminder.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    fun setMessage(message: String){
        _msg.value = message
    }
}