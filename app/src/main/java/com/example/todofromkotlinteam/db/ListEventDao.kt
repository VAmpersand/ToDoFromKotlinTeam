package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent

@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent ORDER BY id DESC")
    fun getAllListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventType LIKE 'PLANS'")
    fun getPlansListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventType LIKE 'IDEAS'")
    fun getIdeasListEvent(): List<ListEvent>?

    @Insert
    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Update
    fun updateListEvent(event: ListEvent?)
}