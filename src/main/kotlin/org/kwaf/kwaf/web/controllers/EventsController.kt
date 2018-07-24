package org.kwaf.kwaf.web.controllers

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class EventsController(private val eventGateway: EventGateway) {
    @GetMapping("/events")
    @ResponseBody
    fun fetchEvents(): Iterable<Event> {
        return eventGateway.findAll()
    }
}
