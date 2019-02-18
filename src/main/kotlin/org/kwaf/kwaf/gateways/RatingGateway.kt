package org.kwaf.kwaf.gateways

import com.google.gson.GsonBuilder
import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.inputs.CalculateRatingResponse
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.text.SimpleDateFormat
import java.util.concurrent.CompletableFuture

@Component
class RatingGateway(private val environment: Environment) {
    @Async
    fun calculateRating(event: Event, previousEvents: Iterable<Event>): CompletableFuture<Double> {
        val gson = GsonBuilder().setDateFormat(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").toPattern()).create()

        val payload = gson.toJson(previousEvents)
        val url = URI("${environment["kwaf.rating_url"]}/rating")
        val request = HttpRequest
                .newBuilder(url)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .header("Content-Type", "application/json;charset=UTF-8")
                .build()
        val client = HttpClient.newHttpClient()

        return client
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply { CalculateRatingResponse(it.body().toDouble()).rating }
                .exceptionally { exception -> 0.0 }
    }
}
