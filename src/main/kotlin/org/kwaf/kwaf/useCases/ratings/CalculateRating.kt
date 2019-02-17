package org.kwaf.kwaf.useCases.ratings

import org.kwaf.kwaf.entities.Event
import org.kwaf.kwaf.gateways.EventGateway
import org.kwaf.kwaf.gateways.RatingGateway
import java.util.function.Function

class CalculateRating(private val eventGateway: EventGateway,
                      private val ratingGateway: RatingGateway) : Function<Event, Double> {
    override fun apply(event: Event): Double {
        val previousEvents = eventGateway.findAllByUserId(event.userId)
        return ratingGateway.calculateRating(event, previousEvents).join()
    }
}
