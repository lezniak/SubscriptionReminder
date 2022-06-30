package com.example.subscriptionreminder.infrastructure.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.subscriptionreminder.infrastructure.model.Subscription
import com.google.firebase.inject.Deferred

@Dao
interface SubscriptionDao {
    @Query("SELECT * FROM subscription")
    fun getAllSubscripton(): LiveData<List<Subscription>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubscription(subscription: Subscription)
}