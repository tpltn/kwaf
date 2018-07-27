package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.URL
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface URLGateway : PagingAndSortingRepository<URL, UUID> {
    fun findByValue(value: String): URL?
}
