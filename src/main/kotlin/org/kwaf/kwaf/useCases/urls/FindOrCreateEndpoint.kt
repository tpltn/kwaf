package org.kwaf.kwaf.useCases.urls

import org.kwaf.kwaf.entities.Endpoint
import org.kwaf.kwaf.gateways.EndpointGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindOrCreateEndpoint(private val endpointGateway: EndpointGateway) {
    fun call(method: String, url: String): Endpoint {
        val endpoint = endpointGateway.findByMethodAndUrl(method, url)

        return if (endpoint != null) {
            endpoint
        } else {
            // TODO: handle unique constraint violation
            val endpointToCreate = Endpoint(UUID.randomUUID(), method, url)
            endpointGateway.save(endpointToCreate)
        }
    }
}
