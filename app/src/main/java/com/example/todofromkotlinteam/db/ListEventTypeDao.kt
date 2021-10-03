package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.model.ListEventType
@Dao
interface ListEventTypeDao {

    @Query("SELECT * FROM listEventType ORDER BY id DESC")
    fun getAllListEventType(): List<ListEventType>?

    @Insert
    fun insertListEventType(event: ListEventType?)

    @Delete
    fun deleteListEventType(event: ListEventType?)

    @Update
    fun updateListEventType(event: ListEventType?)
}