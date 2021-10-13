package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEventType
import com.example.todofromkotlinteam.views.EventsDataField

@Dao
interface ListEventTypeDao {

    @Query("SELECT * FROM listEventType ORDER BY id DESC")
    fun getAllListEventType(): List<ListEventType>?
//
//    @Query("SELECT color FROM listEventType WHERE id ")
//    fun getListEventType(id: Int): List<ListEventType>?

    @Insert
    fun insertListEventType(event: ListEventType?)

    @Delete
    fun deleteListEventType(event: ListEventType?)

    @Update
    fun updateListEventType(event: ListEventType?)

}