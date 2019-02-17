package org.kwaf.kwaf.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "events")
data class Event(
        @Id
        val id: UUID,

        @Column(name = "user_id")
        val userId: UUID,

        @Column(name = "user_agent")
        val userAgent: String,

        @Column(name = "host")
        val host: String,

        @Column(name = "committed_at")
        val committedAt: Date
)
