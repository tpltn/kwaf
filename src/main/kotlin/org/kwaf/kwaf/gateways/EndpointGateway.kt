package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Endpoint
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface EndpointGateway : PagingAndSortingRepository<Endpoint, UUID> {
    fun findByMethodAndUrl(method: String, url: String): Endpoint?
}
