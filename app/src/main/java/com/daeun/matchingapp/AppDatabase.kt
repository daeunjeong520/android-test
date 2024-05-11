package com.daeun.matchingapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daeun.matchingapp.domain.Project

@Database(entities = [Project::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun projectDao(): ProjectDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if(INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "matching-app.db"
                    ).build()
                }
            }
            return INSTANCE;
        }
    }
}