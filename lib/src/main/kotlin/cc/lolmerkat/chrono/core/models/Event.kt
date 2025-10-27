package cc.lolmerkat.chrono.core.models

import java.time.ZonedDateTime

data class Event(
    val id: String,
    val calendarId: String,
    val title: String,
    val description: String?,
    val startTime: ZonedDateTime,
    val endTime: ZonedDateTime,
    val notes: String?,
    val location: String?,
    val people: String?,
    val style: EventStyle?,
    val isDeleted: Boolean = false, // allow soft deletion
    val lastModifiedUtc: Long
)

data class EventStyle(
    val nodeColor: String?,
    val borderColor: String?,
    val borderWidth: Int?
)
