package com.example.subscriptionreminder.infrastructure.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.subscriptionreminder.infrastructure.model.Subscription

@Database(entities = [Subscription::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
}