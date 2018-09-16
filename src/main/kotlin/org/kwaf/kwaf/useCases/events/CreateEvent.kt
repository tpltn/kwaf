package org.kwaf.kwaf.useCases.events

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.useCases.urls.FindOrCreateEndpoint
import org.kwaf.kwaf.useCases.userAgents.FindOrCreateUserAgent
import org.kwaf.kwaf.web.inputs.EventInput
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateEvent(
        private val eventGateway: EventGateway,
        private val findOrCreateEndpoint: FindOrCreateEndpoint,
        private val findOrCreateUserAgent: FindOrCreateUserAgent
) {

    fun call(eventInput: EventInput): Event {
        val endpoint = findOrCreateEndpoint.call(eventInput.method, eventInput.url)
        val userAgent = findOrCreateUserAgent.call(eventInput.userAgent)

        val event = Event(
                UUID.randomUUID(),
                eventInput.userId,
                userAgent,
                endpoint,
                eventInput.httpStatus,
                eventInput.committedAt
        )

        return eventGateway.save(event)
    }
}
