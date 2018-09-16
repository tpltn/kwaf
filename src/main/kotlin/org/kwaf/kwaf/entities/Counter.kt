package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Table

@Table(name = "counters")
data class Counter(
        @Column(name = "user_id")
        val userId: UUID,

        @Column(name = "endpoint_id")
        val endpointId: UUID,

        @Column(name = "total_events")
        val total_events: Int
)
