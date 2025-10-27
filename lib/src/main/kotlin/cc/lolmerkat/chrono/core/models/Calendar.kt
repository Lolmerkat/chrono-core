package cc.lolmerkat.chrono.core.models

data class Calendar(
    val id: String,
    val name: String,
    val defaultEventStyle: EventStyle,
    val isDeleted: Boolean = false,
    val lastModifiedUtc: Long
)
