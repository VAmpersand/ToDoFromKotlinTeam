package com.example.todofromkotlinteam.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "listEvent")
data class ListEvent(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "eventType") val eventTypeId: Int,
    @ColumnInfo(name = "eventTypeName") val eventTypeName: String?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "startTime") val startTime: String, // format HH:mm
    @ColumnInfo(name = "finishTime") val finishTime: String, // format HH:mm
    @ColumnInfo(name = "partner") val partner: String?,
    @ColumnInfo(name = "isDone") val isDone: Boolean,
    @ColumnInfo(name = "isPriority") val isPriority: Boolean
) : Serializable




