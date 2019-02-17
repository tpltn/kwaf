package org.kwaf.kwaf.web.controllers

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.useCases.events.CreateEvent
import org.kwaf.kwaf.web.inputs.EventInput
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class EventsController(private val eventGateway: EventGateway, private val createEvent: CreateEvent) {
    @GetMapping("/events")
    @ResponseBody
    fun fetchEvents(): Iterable<Event> {
        return eventGateway.findAll()
    }

    @PostMapping("/events")
    @ResponseBody
    fun createEvent(
            @RequestBody
            e: EventInput
    ): Event? {
        return createEvent.apply(e)
    }
}
