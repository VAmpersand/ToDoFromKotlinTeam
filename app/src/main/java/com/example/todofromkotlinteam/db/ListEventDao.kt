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

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'IDEAS' ORDER BY id ASC")
    fun getIdeasListEvent(): List<ListEvent>?

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Insert()
    fun insertListEvent(event: ListEvent?): Long

    @Update()
    fun updateListEvent(event: ListEvent?)

}