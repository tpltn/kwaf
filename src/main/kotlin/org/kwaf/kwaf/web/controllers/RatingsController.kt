package org.kwaf.kwaf.web.controllers

import org.kwaf.kwaf.entities.Rating
import org.kwaf.kwaf.gateways.RatingGateway
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

@Controller
class RatingsController(private val ratingGateway: RatingGateway) {
    @GetMapping("/ratings")
    @ResponseBody
    fun fetchRatings(@RequestParam(value = "user_id", required = false) userId: UUID?): Iterable<Rating> {
        return if (userId != null) {
            ratingGateway.findByUserId(userId)
        } else {
            ratingGateway.findAll()
        }
    }
}
