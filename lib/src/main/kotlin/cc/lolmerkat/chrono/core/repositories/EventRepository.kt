package cc.lolmerkat.chrono.core.repositories

import cc.lolmerkat.chrono.core.models.Event

interface EventRepository {
    fun save(event: Event)
    fun findById(id: String): Event?
    fun hasChangesSince(event: Event, timeStamp: Long): Boolean
    fun getChangesSince(timeStamp: Long): List<Event>
}
