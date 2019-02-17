package org.kwaf.kwaf.gateways

import org.kwaf.kwaf.entities.Event
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.concurrent.CompletableFuture

@Component
class RatingGateway(private val environment: Environment) {
    @Async
    fun calculateRating(event: Event, previousEvents: Iterable<Event>): CompletableFuture<Double> {

        val url = URI("${environment["kwaf.rating_url"]}/rating")

        // TODO: set payload
        val request = HttpRequest
                .newBuilder(url)
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Content-Type", "application/json;charset=UTF-8")
                .build()
        val client = HttpClient.newHttpClient()


        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply { it.body().toDouble() }
    }
}
