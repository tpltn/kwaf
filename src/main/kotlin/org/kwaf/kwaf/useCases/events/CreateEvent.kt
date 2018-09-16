package org.kwaf.kwaf.useCases.events

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.useCases.counters.IncrementCounter
import org.kwaf.kwaf.useCases.urls.FindOrCreateEndpoint
import org.kwaf.kwaf.useCases.userAgents.FindOrCreateUserAgent
import org.kwaf.kwaf.web.inputs.EventInput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
@Transactional
class CreateEvent(
        private val eventGateway: EventGateway,
        private val findOrCreateEndpoint: FindOrCreateEndpoint,
        private val findOrCreateUserAgent: FindOrCreateUserAgent,
        private val incrementCounter: IncrementCounter
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

        val savedEvent = eventGateway.save(event)
        incrementCounter.call(savedEvent.userId, savedEvent.endpoint.id)

        return savedEvent
    }
}
