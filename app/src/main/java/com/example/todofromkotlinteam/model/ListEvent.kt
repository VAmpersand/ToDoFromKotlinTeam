package com.example.todofromkotlinteam.model

data class ListEvent(
    var eventType: ListEventType,
    var title: String,
    var description: String,
    var startTime: String, // format HH:mm
    var finishTime: String, // format HH:mm
    var partner: String,
    var isDone: Boolean,
    var isPriority: Boolean
)