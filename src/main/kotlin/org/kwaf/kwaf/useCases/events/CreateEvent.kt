package org.kwaf.kwaf.useCases.events

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.inputs.EventInput
import org.kwaf.kwaf.useCases.ratings.CalculateRating
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

@Component
class CreateEvent(private val eventGateway: EventGateway,
                  private val calculateRating: CalculateRating) : Function<EventInput, Event> {
    override fun apply(eventInput: EventInput): Event {
        val event = Event(
                UUID.randomUUID(),
                eventInput.userId,
                eventInput.userAgent,
                eventInput.host,
                Date(),
                rating = null
        )
        val rating = calculateRating.apply(event)
        val eventWithRating = event.copy(rating = rating)

        return eventGateway.save(eventWithRating)
    }
}
