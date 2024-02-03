package com.myweatherapp.di.dbmodule

import android.content.Context
import androidx.room.Room
import com.myweatherapp.data.db.AppDatabase
import com.myweatherapp.data.db.dao.HistoryDao
import com.myweatherapp.data.db.dao.UsersDao
import com.myweatherapp.di.networkmodule.ApiHelper
import com.myweatherapp.di.networkmodule.ApiHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "UsersDatabase"
    ).build()

    @Provides
    fun provideUsersDao(appDatabase: AppDatabase): UsersDao {
        return appDatabase.usersDao()
    }

    @Provides
    fun provideHistoryDao(appDatabase: AppDatabase): HistoryDao {
        return appDatabase.historyDao()
    }

    @Provides
    @Singleton
    fun provideApiHelper(dbHelperImpl: DBHelperImpl): DBHelper = dbHelperImpl

}