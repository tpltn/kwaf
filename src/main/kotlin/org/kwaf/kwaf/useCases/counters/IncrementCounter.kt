package org.kwaf.kwaf.useCases.counters

import org.kwaf.kwaf.gateways.CounterGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class IncrementCounter(private val counterGateway: CounterGateway) {
    fun call(userId: UUID, endpointId: UUID): Int {
        return counterGateway.incrementTotalEvents(userId, endpointId)
    }
}
