package cc.lolmerkat.chrono.core.repositories

import cc.lolmerkat.chrono.core.models.Calendar

interface CalendarRepository {
    fun save(calendar: Calendar)
    fun delete(calendar: Calendar)
    fun findById(id: String): Calendar?
    fun hasChangesSince(calendar: Calendar, timeStamp: Long): Boolean
    fun getChangesSince(timeStamp: Long): List<Calendar>
}
