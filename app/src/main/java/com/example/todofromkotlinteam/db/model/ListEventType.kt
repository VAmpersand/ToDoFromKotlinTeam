package com.example.todofromkotlinteam.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listEventType")
data class ListEventType(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
        @ColumnInfo(name = "color") val color: String,
        @ColumnInfo(name = "title") val title: String,
)