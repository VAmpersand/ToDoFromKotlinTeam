package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent

@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'PLANS'")
    fun getAllListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'IDEAS'")
    fun getIdeasListEvent(): List<ListEvent>?


    @Insert
    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Update
    fun updateListEvent(event: ListEvent?)
}