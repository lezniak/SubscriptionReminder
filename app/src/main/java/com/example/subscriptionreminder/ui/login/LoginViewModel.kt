package com.example.subscriptionreminder.ui.login

import android.R.attr
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    fun setMessage(message: String){
        _msg.value = message
    }
}