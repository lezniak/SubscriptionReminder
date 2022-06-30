package com.example.subscriptionreminder.infrastructure.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity
data class Subscription(
    @PrimaryKey
    val id: Int,
    val company: String,
    val comment: String,
    val dateStart: String,
    val dateEnd: String,
    val price: Int
)
