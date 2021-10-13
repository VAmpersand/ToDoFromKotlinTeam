package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.Color
import com.example.todofromkotlinteam.db.model.ListEventType

@Dao
interface ListEventTypeDao {

    @Query("SELECT * FROM listEventType ORDER BY id DESC")
    fun getAllListEventType(): List<ListEventType>?

    @Query("SELECT color FROM listEventType WHERE id = :colorId" )
     fun getColorEventType(colorId: Int?): List<Color>?


    @Insert
    fun insertListEventType(event: ListEventType?)


    @Delete
    fun deleteListEventType(event: ListEventType?)

    @Update
    fun updateListEventType(event: ListEventType?)



}