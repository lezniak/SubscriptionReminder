package com.example.subscriptionreminder.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.subscriptionreminder.infrastructure.db.SubscriptionDao
import com.example.subscriptionreminder.infrastructure.model.Subscription
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val subscriptionDao: SubscriptionDao) : ViewModel() {
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    fun setMessage(message: String){
        _msg.value = message
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            val test = Subscription(0,"Spotyfi","usunac",currentDate,currentDate,55)
            subscriptionDao.insertSubscription(test)
        }
    }
}