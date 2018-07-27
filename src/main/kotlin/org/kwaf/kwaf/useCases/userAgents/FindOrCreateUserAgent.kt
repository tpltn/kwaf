package org.kwaf.kwaf.useCases.userAgents

import org.kwaf.kwaf.entities.UserAgent
import org.kwaf.kwaf.gateways.UserAgentGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindOrCreateUserAgent(private val userAgentGateway: UserAgentGateway) {
    fun call(name: String): UserAgent {
        val userAgent = userAgentGateway.findByName(name)

        if (userAgent != null) {
            return userAgent
        } else {
            val userAgentToCreate = UserAgent(UUID.randomUUID(), name)
            return userAgentGateway.save(userAgentToCreate)
        }
    }
}
