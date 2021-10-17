package com.example.todofromkotlinteam.db


import androidx.room.*
import com.example.todofromkotlinteam.db.model.Color

import com.example.todofromkotlinteam.db.model.ListEventType


@Dao
interface ListEventTypeDao {

    @Query("SELECT * FROM listEventType ORDER BY id DESC")
    fun getAllListEventType(): List<ListEventType>?

    @Query("SELECT color FROM listEventType WHERE id = :id" )
     fun getColorType(id: Int): Color?

//    @Query("SELECT *,(SELECT color FROM listEventType WHERE id = :id) FROM listEvent ")
//    fun getColor(id: Int): ListEventType?

//    @Query("SELECT * FROM listEventType WHERE Id IN (SELECT eventType FROM listEvent)")
//    fun getColor(): ListEventType?


    @Insert
    fun insertListEventType(event: ListEventType?)


    @Delete
    fun deleteListEventType(event: ListEventType?)

    @Update
    fun updateListEventType(event: ListEventType?)



}