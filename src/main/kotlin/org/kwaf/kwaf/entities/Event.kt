package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "events")
data class Event(
        @Id
        val id: UUID,

        @Column(name = "user_id")
        val userId: UUID,

        @ManyToOne
        @JoinColumn(name = "user_agent_id")
        val userAgent: UserAgent,

        @ManyToOne
        @JoinColumn(name = "endpoint_id")
        val endpoint: Endpoint,

        @Column(name = "http_status")
        val httpStatus: Int,

        @Column(name = "committed_at")
        val committedAt: Date
)
