package com.myweatherapp.di.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(@PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("userName") val userName: String,
    @ColumnInfo("userPass") val userPass: String,
    )