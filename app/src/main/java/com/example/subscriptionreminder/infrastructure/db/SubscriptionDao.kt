package com.example.subscriptionreminder.infrastructure.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.subscriptionreminder.infrastructure.model.Subscription

@Dao
interface SubscriptionDao {
    @Query("SELECT * FROM subscription")
    fun getAllSubscripton(): List<Subscription>

    @Insert
    fun insertSubscription(subscription: Subscription)
}