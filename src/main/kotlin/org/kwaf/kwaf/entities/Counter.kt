package org.kwaf.kwaf.entities

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
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
) : Serializable
