package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent
import androidx.room.OnConflictStrategy
import androidx.room.Update
import android.provider.SyncStateContract.Helpers.update

import android.database.sqlite.SQLiteConstraintException

import android.provider.SyncStateContract.Helpers.insert
import androidx.room.OnConflictStrategy.*


@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'PLANS' ORDER BY id DESC")
    fun getAllListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'IDEAS' ORDER BY id DESC")
    fun getIdeasListEvent(): List<ListEvent>?

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

//    @Update()
//    fun updateListEvent(event: ListEvent?)

    @Insert()
    fun insertListEvent(event: ListEvent?): Long

    @Update()
    fun updateListEvent(event: ListEvent?)

//    @Transaction
//    fun upsertListEvent(event: ListEvent?) {
//        val id = insertListEvent(event)
//        if (id == -1L) {
//            updateListEvent(event)
//        }
//    }

//    @Transaction
//    fun upsertListEvent(event: ListEvent?) {
//        try {
//            insertListEvent(event)
//        } catch (exception: SQLiteConstraintException) {
//            updateListEvent(event)
//        }
//    }

}