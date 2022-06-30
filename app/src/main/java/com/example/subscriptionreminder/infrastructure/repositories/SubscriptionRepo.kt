package com.example.subscriptionreminder.infrastructure.repositories

import androidx.lifecycle.LiveData
import com.example.subscriptionreminder.infrastructure.db.SubscriptionDao
import com.example.subscriptionreminder.infrastructure.model.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class SubscriptionRepo @Inject constructor(private val subscriptionDao: SubscriptionDao) {

    fun getSubscription(): LiveData<List<Subscription>>{
        return subscriptionDao.getAllSubscripton()
    }

}