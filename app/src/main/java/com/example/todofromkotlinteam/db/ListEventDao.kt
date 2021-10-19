package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.db.model.ListEventType

@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'PLANS' ORDER BY id DESC")
    fun getAllListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'IDEAS' ORDER BY id DESC")
    fun getIdeasListEvent(): List<ListEvent>?

    @Insert
    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Update()
    fun updateListEvent(event: ListEvent?){

    }
}