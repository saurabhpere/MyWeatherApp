package com.myweatherapp.data.db.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity
data class Users(
    @ColumnInfo("userName") val userName: String,
    @ColumnInfo("userPass") val userPass: String,
    ){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}