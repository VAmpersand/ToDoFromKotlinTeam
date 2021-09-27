package com.example.todofromkotlinteam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listEvent")
data class ListEvent(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "eventType") val eventType: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "startTime") val startTime: String, // format HH:mm
    @ColumnInfo(name = "finishTime") val finishTime: String, // format HH:mm
    @ColumnInfo(name = "partner") val partner: String,
    @ColumnInfo(name = "isDone") val isDone: Boolean,
    @ColumnInfo(name = "isPriority") val isPriority: Boolean,

//    var eventType: ListEventType,
//    var title: String,
//    var description: String,
//    var startTime: String, // format HH:mm
//    var finishTime: String, // format HH:mm
//    var partner: String,
//    var isDone: Boolean,
//    var isPriority: Boolean
)