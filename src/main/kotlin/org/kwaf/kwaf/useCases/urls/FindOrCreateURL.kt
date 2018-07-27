package org.kwaf.kwaf.useCases.urls

import org.kwaf.kwaf.entities.URL
import org.kwaf.kwaf.gateways.URLGateway
import org.springframework.stereotype.Component
import java.util.*

// TODO: move to gateway
@Component
class FindOrCreateURL(private val urlGateway: URLGateway) {
    fun call(value: String): URL {
        val url = urlGateway.findByValue(value)

        if (url != null) {
            return url
        } else {
            val urlToCreate = URL(UUID.randomUUID(), value)
            return urlGateway.save(urlToCreate)
        }
    }
}
