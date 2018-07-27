package org.kwaf.kwaf.useCases.events

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.useCases.urls.FindOrCreateURL
import org.kwaf.kwaf.useCases.userAgents.FindOrCreateUserAgent
import org.kwaf.kwaf.web.inputs.EventInput
import org.springframework.stereotype.Component
import java.util.*

@Component
class CreateEvent(private val eventGateway: EventGateway,
                  private val findOrCreateURL: FindOrCreateURL,
                  private val findOrCreateUserAgent: FindOrCreateUserAgent) {

    fun call(eventInput: EventInput): Event {
        val url = findOrCreateURL.call(eventInput.url)
        val userAgent = findOrCreateUserAgent.call(eventInput.userAgent)

        val event = Event(UUID.randomUUID(), eventInput.userId, userAgent, url, eventInput.method, eventInput.httpStatus, eventInput.committedAt)

        return eventGateway.save(event)
    }
}
