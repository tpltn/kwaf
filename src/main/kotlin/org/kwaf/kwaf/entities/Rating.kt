package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(UserEndpointId::class)
data class Rating(
        @Id
        @Column(name = "user_id")
        val userId: UUID,

        @Id
        @Column(name = "endpoint_id")
        val endpointId: UUID,

        @Column(name = "total_events")
        val totalEvents: Int,

        @Column(name = "events_per_endpoint")
        val eventsPerEndpoint: Int,

        @Column(name = "average_rate")
        val averageRate: Double
)
