package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.UserAgent
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface UserAgentGateway : PagingAndSortingRepository<UserAgent, UUID> {
    fun findByName(name: String): UserAgent?
}
