package com.example.subscriptionreminder.ui.conf

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.subscriptionreminder.infrastructure.db.AppDatabase
import com.example.subscriptionreminder.infrastructure.db.SubscriptionDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@HiltAndroidApp
class HiltApp : Application() {


}