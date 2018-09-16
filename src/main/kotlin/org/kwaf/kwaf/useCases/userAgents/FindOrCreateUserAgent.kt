package org.kwaf.kwaf.useCases.userAgents

import org.kwaf.kwaf.entities.UserAgent
import org.kwaf.kwaf.gateways.UserAgentGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindOrCreateUserAgent(private val userAgentGateway: UserAgentGateway) {
    fun call(name: String): UserAgent {
        val userAgent = userAgentGateway.findByName(name)

        return if (userAgent != null) {
            userAgent
        } else {
            // TODO: handle unique constraint violation
            val userAgentToCreate = UserAgent(UUID.randomUUID(), name)
            userAgentGateway.save(userAgentToCreate)
        }
    }
}
