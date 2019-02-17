package org.kwaf.kwaf.useCases.events

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.web.inputs.EventInput
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

@Component
class CreateEvent(private val eventGateway: EventGateway) : Function<EventInput, Event> {
    override fun apply(eventInput: EventInput): Event {
        val event = Event(
                UUID.randomUUID(),
                eventInput.userId,
                eventInput.userAgent,
                eventInput.host,
                Date()
        )

        return eventGateway.save(event)
    }
}
