package com.example.todofromkotlinteam.db

import androidx.room.*
import com.example.todofromkotlinteam.db.model.ListEvent
import com.example.todofromkotlinteam.db.model.ListEventType

@Dao
interface ListEventDao {

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'PLANS' ORDER BY id ASC")
    fun getAllListEvent(): List<ListEvent>?

    @Query("SELECT * FROM listEvent WHERE eventTypeName LIKE 'IDEAS' ORDER BY id ASC")
    fun getIdeasListEvent(): List<ListEvent>?

//    @Query("SELECT * FROM listEvent WHERE Id IN (SELECT color FROM listEventType)")
//    fun getColor(): List<ListEvent>?

//    @Query("SELECT listEventType.color,listEventType.id, listEvent.eventType FROM listEventType, listEvent WHERE listEvent.eventType == listEventType.color ")
//    fun getColor(): List<ListEvent>?

    @Insert
    fun insertListEvent(event: ListEvent?)

    @Delete
    fun deleteListEvent(event: ListEvent?)

    @Update
    fun updateListEvent(event: ListEvent?)
}