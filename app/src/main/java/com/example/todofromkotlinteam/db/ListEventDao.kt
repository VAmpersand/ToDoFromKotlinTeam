package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent

@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent ORDER BY id DESC")
    fun getAllListEvent(): List<ListEvent>?

    @Insert
    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Update
    fun updateListEvent(event: ListEvent?)
}