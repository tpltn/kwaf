package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Event
import org.springframework.data.repository.PagingAndSortingRepository

interface EventGateway : PagingAndSortingRepository<Event, String> {
}
