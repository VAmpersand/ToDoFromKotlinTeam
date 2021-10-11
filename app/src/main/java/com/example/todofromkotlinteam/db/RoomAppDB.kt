package com.example.todofromkotlinteam.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.db.model.ListEventType

@Database(entities = [ListEvent::class, ListEventType::class], version = 2)
abstract class RoomAppDB : RoomDatabase() {
    abstract fun listEventDao(): ListEventDao?
    abstract fun listEventTypeDao(): ListEventTypeDao?

    companion object {
        private var INSTANCE: RoomAppDB? = null

        fun getAppDB(context: Context): RoomAppDB? {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, RoomAppDB::class.java, "AppDB"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationFrom(1,2)
                    .build()
            }
            return INSTANCE
        }
    }
}