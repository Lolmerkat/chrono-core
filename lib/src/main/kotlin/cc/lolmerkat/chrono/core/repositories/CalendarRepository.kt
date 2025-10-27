package cc.lolmerkat.chrono.core.repositories

import cc.lolmerkat.chrono.core.models.Calendar

interface CalendarRepository {
    fun save(event: Calendar)
    fun findById(id: String): Calendar?
    fun hasChangesSince(event: Calendar, timeStamp: Long): Boolean
    fun getChangesSince(timeStamp: Long): List<Calendar>
}
