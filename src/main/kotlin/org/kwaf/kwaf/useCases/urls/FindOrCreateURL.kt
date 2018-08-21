package org.kwaf.kwaf.useCases.urls

import org.kwaf.kwaf.entities.URL
import org.kwaf.kwaf.gateways.URLGateway
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindOrCreateURL(private val urlGateway: URLGateway) {
    fun call(value: String): URL {
        val url = urlGateway.findByValue(value)

        if (url != null) {
            return url
        } else {
            // TODO: handle unique constraint violation
            val urlToCreate = URL(UUID.randomUUID(), value)
            return urlGateway.save(urlToCreate)
        }
    }
}
