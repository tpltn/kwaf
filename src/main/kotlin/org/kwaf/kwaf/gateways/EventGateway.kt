package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Event
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface EventGateway : PagingAndSortingRepository<Event, UUID> {
    fun findAllByUserId(userId: UUID): Iterable<Event>
}
