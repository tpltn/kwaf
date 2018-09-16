package org.kwaf.kwaf.web.controllers

import org.kwaf.kwaf.entities.Counter
import org.kwaf.kwaf.gateways.CounterGateway
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CountersController(private val counterGateway: CounterGateway) {
    @GetMapping("/counters")
    @ResponseBody
    fun fetchEvents(): Iterable<Counter> {
        return counterGateway.findAll()
    }
}
