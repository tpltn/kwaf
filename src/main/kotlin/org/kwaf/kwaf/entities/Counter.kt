package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.*

@Entity
@IdClass(CounterId::class)
@Table(name = "counters")
data class Counter(
        @Id
        @Column(name = "user_id")
        val userId: UUID,

        @Id
        @Column(name = "endpoint_id")
        val endpointId: UUID,

        @Column(name = "total_events")
        val total_events: Int
)
