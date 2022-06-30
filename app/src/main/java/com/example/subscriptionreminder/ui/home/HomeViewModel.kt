package com.example.subscriptionreminder.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.subscriptionreminder.infrastructure.db.SubscriptionDao
import com.example.subscriptionreminder.infrastructure.model.Subscription
import com.example.subscriptionreminder.infrastructure.repositories.SubscriptionRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val subscriptionRepo: SubscriptionRepo) : ViewModel() {
    val  subscriptionList = subscriptionRepo.getSubscription()
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    fun setMessage(message: String){
        _msg.value = message
    }
}