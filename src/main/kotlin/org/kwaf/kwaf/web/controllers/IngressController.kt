package org.kwaf.kwaf.web.controllers

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.inputs.EventInput
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Mono
import java.util.*

import java.util.function.Function

@Controller
class IngressController(private val createEvent: Function<EventInput, Event>) {
    @RequestMapping(
            method = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE],
            value = ["/ingress/**"]
    )
    @ResponseBody
    fun call(@RequestHeader(value = "User-Agent") userAgent: String,
             @RequestHeader(value = "User-Id", required = false) userId: Optional<UUID>,
             request: ServerHttpRequest): Mono<Event> {
        val host = request.remoteAddress!!.address.hostAddress
        val input = EventInput(userId.orElse(UUID.randomUUID()), host, userAgent)

        return Mono.just(createEvent.apply(input))
    }
}
