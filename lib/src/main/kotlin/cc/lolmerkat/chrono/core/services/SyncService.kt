package cc.lolmerkat.chrono.core.services

import cc.lolmerkat.chrono.core.repositories.CalendarRepository
import cc.lolmerkat.chrono.core.repositories.EventRepository
import cc.lolmerkat.chrono.core.models.*

class SyncService (
    private val eventRepository: EventRepository,
    private val calendarRepository: CalendarRepository,
) {
    data class SyncPayload(
        val events: List<Event>,
        val calendars: List<Calendar>
    )

    fun performSync(
        clientChanges: SyncPayload, lastSyncTimestamp: Long
    ): SyncPayload {
        clientChanges.events.forEach { clientEvent ->
            val serverEvent = eventRepository.findById(clientEvent.id)
            if (serverEvent == null
            || clientEvent.lastModified > serverEvent.lastModified) {
                eventRepository.save(clientEvent)
            }
        }

        clientChanges.calendars.forEach { clientCalendar ->
            val serverCalendar = calendarRepository.findById(clientCalendar.id)
            if (serverCalendar == null
            || clientCalendar.lastModified > serverCalendar.lastModified) {
                calendarRepository.save(clientCalendar)
            }
        }

        val serverEvents = eventRepository.getChangesSince(lastSyncTimestamp)
        val serverCalendars = calendarRepository.getChangesSince(lastSyncTimestamp)

        return SyncPayload(
            events = serverEvents,
            calendars = serverCalendars
        )
    }
}
