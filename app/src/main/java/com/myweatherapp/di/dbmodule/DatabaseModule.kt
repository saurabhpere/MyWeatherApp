package com.myweatherapp.di.dbmodule

import android.content.Context
import androidx.annotation.Keep
import androidx.room.Room
import com.myweatherapp.data.db.AppDatabase
import com.myweatherapp.data.db.dao.HistoryDao
import com.myweatherapp.data.db.dao.UsersDao
import com.myweatherapp.resource.Keys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.zetetic.database.sqlcipher.SQLiteDatabase
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton

val factory: SupportOpenHelperFactory = SupportOpenHelperFactory(Keys.sqlKey().toByteArray(Charsets.UTF_8))

@Keep
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "UsersDatabase"
    ).openHelperFactory(factory).build()

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